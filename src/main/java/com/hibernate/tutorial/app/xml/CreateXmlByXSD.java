/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.app.xml;

import com.hibernate.tutorial.app.xml.entity.ObjectFactory;
import com.hibernate.tutorial.app.xml.entity.Packet;
import com.hibernate.tutorial.entity.Sertif;
import com.hibernate.tutorial.entity.SpisokVrach;
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

/**
 *
 * @author Талалаев
 */
public class CreateXmlByXSD {

    public Packet prepareData(List<SpisokVrach> listDoctors, List<Sertif> listCertificate,Date currentDate) {
        ObjectFactory factory = new ObjectFactory();
        Packet packet = factory.createPacket();
        List<Packet.ZAP> listZap = packet.getZAP();

        for (SpisokVrach doctor : listDoctors) {
            Packet.ZAP zap = factory.createPacketZAP();
            zap.setIDDOCT(doctor.getIddokt());
            zap.setLPUKOD(doctor.getLpukod().toString());
            zap.setFAM(doctor.getFam());
            zap.setIM(doctor.getIm());
            zap.setOT(doctor.getOt());
            if (doctor.getDokt()) {
                zap.setDOKT((byte) 1);
            } else {
                zap.setDOKT((byte) 0);
            }

            List<Packet.ZAP.SERTIF> ls = zap.getSERTIF();

            Predicate condition = new Predicate() {
                public boolean evaluate(Object sample) {
                    return ((Sertif) sample).getIddokt().getIddokt().equals(doctor.getIddokt());
                }
            };
            List<Sertif> result = (List<Sertif>) CollectionUtils.select(listCertificate, condition);

          
            Predicate condition2 = new Predicate() {
                public boolean evaluate(Object sample) {
                    return ((Sertif) sample).getDateEnd().after(currentDate);
                }
            };
            List<Sertif> result2 = (List<Sertif>) CollectionUtils.select(result, condition2);
            for (Sertif sertif : result2) {
                Packet.ZAP.SERTIF srt = factory.createPacketZAPSERTIF();
                srt.setNSERT(sertif.getNSert());
                srt.setREGNUM(sertif.getRegNum());
                srt.setDATEEND(DateFormatUtils.format(sertif.getDateEnd(), "yyyy-MM-dd HH:mm:SS"));
                ls.add(srt);
                zap.setSertif(ls);
            }

            listZap.add(zap);

        }
        packet.setZap(listZap);
        
        return packet;

    }

    public void createXml(String filename, List<SpisokVrach> listDoctors, List<Sertif> listCertificate) throws JAXBException, FileNotFoundException { 
        JAXBContext jc = JAXBContext.newInstance("com.hibernate.tutorial.app.xml.entity");
        Marshaller m = jc.createMarshaller();
        OutputStream os = new FileOutputStream("output.xml");
        Packet element = prepareData(listDoctors,listCertificate,new Date());
        m.marshal(element, os);
    }

}
