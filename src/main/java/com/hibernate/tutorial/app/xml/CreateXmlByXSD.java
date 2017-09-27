/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.app.xml;

import com.hibernate.tutorial.app.xml.entity.ObjectFactory;
import com.hibernate.tutorial.app.xml.entity.Packet;
import com.hibernate.tutorial.config.SpringContext;
import com.hibernate.tutorial.entity.Sertif;
import com.hibernate.tutorial.entity.SpisokVrach;
import com.hibernate.tutorial.service.HibernateMain;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Талалаев
 */
public class CreateXmlByXSD {

    HibernateMain hiber;
    private ApplicationContext context;

    public Packet prepareData( Date currentDate) {

        context = new AnnotationConfigApplicationContext(SpringContext.class);
        hiber = (HibernateMain) context.getBean("HibernateMain");
       List<SpisokVrach> listDoctors= hiber.getSpisokVrach();
        List<Sertif> listCertificate=hiber.getSertifAll();

        ObjectFactory factory = new ObjectFactory();
        Packet packet = factory.createPacket();
        List<Packet.ZAP> listZap = packet.getZAP();

        for (SpisokVrach doctor : listDoctors) {
            Packet.ZAP zap = factory.createPacketZAP();
            zap.setIDDOCT(doctor.getIddokt());
            if (doctor.getLpukod()!=null) zap.setLPUKOD(doctor.getLpukod().toString());
            
            zap.setFAM(doctor.getFam());
            zap.setIM(doctor.getIm());
            if (doctor.getOt()!=null) zap.setOT(doctor.getOt());
            if (doctor.getDokt()!=null && (doctor.getDokt())) {
                zap.setDOKT((byte) 1);
            } else {
                zap.setDOKT((byte) 0);
            }

            List<Packet.ZAP.SERTIF> ls = zap.getSERTIF();
   
            Predicate condition = (Object sample) -> ((Sertif) sample).getIddokt().getIddokt().equals(doctor.getIddokt());
            List<Sertif> result = (List<Sertif>) CollectionUtils.select(listCertificate, condition);

            Predicate condition2 = new Predicate() {
                @Override
                public boolean evaluate(Object sample) {
                    return ((Sertif) sample).getDateEnd().after(currentDate);
                }
            };
            List<Sertif> result2 = (List<Sertif>) CollectionUtils.select(result, condition2);
            for (Sertif sertif : result2) {
                Packet.ZAP.SERTIF srt = factory.createPacketZAPSERTIF();
                srt.setNSERT(sertif.getNSert());
                srt.setREGNUM(sertif.getRegNum());
                srt.setDATEEND(DateFormatUtils.format(sertif.getDateEnd(), "yyyy-MM-dd"));
                ls.add(srt);
                zap.setSertif(ls);
            }

            listZap.add(zap);

        }
        packet.setZap(listZap);

        return packet;

    }

    public void createXml(Date currentDate,String selectedfile) throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance("com.hibernate.tutorial.app.xml.entity");
        Marshaller m = jc.createMarshaller();
        OutputStream os = new FileOutputStream(selectedfile);
        Packet element = prepareData(currentDate);
        m.marshal(element, os);
    }

}
