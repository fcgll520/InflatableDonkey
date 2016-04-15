/*
 * The MIT License
 *
 * Copyright 2016 Ahseya.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.horrorho.inflatabledonkey.cloud.voodoo;

import com.github.horrorho.inflatabledonkey.protocol.ChunkServer;
import java.util.Objects;
import net.jcip.annotations.Immutable;

/**
 * StorageHostChunkListContainer.
 *
 * @author Ahseya
 */
@Immutable
public final class StorageHostChunkListContainer {

    private final ChunkServer.StorageHostChunkList storageHostChunkList;
    private final int container;

    public StorageHostChunkListContainer(ChunkServer.StorageHostChunkList storageHostChunkList, int container) {
        this.storageHostChunkList = Objects.requireNonNull(storageHostChunkList, "storageHostChunkList");
        this.container = container;
    }

    public ChunkServer.StorageHostChunkList storageHostChunkList() {
        return storageHostChunkList;
    }

    public int container() {
        return container;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.storageHostChunkList);
        hash = 67 * hash + this.container;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StorageHostChunkListContainer other = (StorageHostChunkListContainer) obj;
        if (this.container != other.container) {
            return false;
        }
        if (!Objects.equals(this.storageHostChunkList, other.storageHostChunkList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorageHostChunkListContainer{" + "storageHostChunkList=" + storageHostChunkList + ", container=" + container + '}';
    }
}
