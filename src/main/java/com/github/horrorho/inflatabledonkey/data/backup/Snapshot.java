/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.horrorho.inflatabledonkey.data.backup;

import com.dd.plist.NSDictionary;
import com.github.horrorho.inflatabledonkey.protocol.CloudKit;
import com.github.horrorho.inflatabledonkey.util.PLists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Snapshot.
 *
 * @author Ahseya
 */
@Immutable
public final class Snapshot extends AbstractRecord {

    private static final Logger logger = LoggerFactory.getLogger(Snapshot.class);

    private final Optional<byte[]> backupProperties;
    private final List<Manifest> manifests;

    public Snapshot(
            Optional<byte[]> backupProperties,
            List<Manifest> manifests,
            CloudKit.Record record) {

        super(record);
        this.backupProperties = Objects.requireNonNull(backupProperties, "backupProperties");
        this.manifests = Objects.requireNonNull(manifests, "manifests");
    }

    public Optional<NSDictionary> backupProperties() {
        return backupProperties.map(bs -> PLists.<NSDictionary>parseLegacy(bs));
    }

    public List<Manifest> manifests() {
        return new ArrayList<>(manifests);
    }

    @Override
    public String toString() {
        return "Snapshot{"
                + super.toString()
                + ", backupProperties=" + backupProperties
                + ", manifests=" + manifests
                + '}';
    }
}
