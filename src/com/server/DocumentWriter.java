package com.server;

import com.company.Character.PlayerCharacter;
import org.bson.Document;

public class DocumentWriter {

    public static Document writeAttribute(PlayerCharacter host){
        Document statsDocument = new Document();

        host.get_Race().getAttributeStats().keySet().forEach(x -> statsDocument.append(x.toString(), host.get_Race().getAttributeStatsValue(x)));
        return statsDocument;
    }

    public static Document writeModify(PlayerCharacter host){
        Document statsDocument = new Document();

        host.get_Race().getModifyStats().keySet().forEach(x -> statsDocument.append(x.toString(), host.get_Race().getModifyStatsValue(x)));
        return statsDocument;
    }
}
