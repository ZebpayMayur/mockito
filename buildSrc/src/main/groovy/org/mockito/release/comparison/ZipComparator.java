package org.mockito.release.comparison;

import groovy.lang.Closure;

import java.io.File;

import static org.mockito.release.util.ArgumentValidation.notNull;

class ZipComparator {

    private Closure<File> file1;
    private Closure<File> file2;

    ZipComparator setPair(Closure<File> file1, Closure<File> file2) {
        notNull(file1, "zip/jar file to compare", file2, "zip/jar file to compare");
        this.file1 = file1;
        this.file2 = file2;
        return this;
    }

    Result compareFiles() {
        final File file1 = this.file1.call();
        final File file2 = this.file2.call();
        notNull(file1, "zip/jar file to compare", file2, "zip/jar file to compare");

        FileHasher hasher = new FileHasher();
        final byte[] hash1 = hasher.hash(file1);
        final byte[] hash2 = hasher.hash(file2);

        final boolean equals = new ZipCompare().compareZips(file1.getAbsolutePath(), file2.getAbsolutePath());

        return new Result() {
            public boolean areEqual() { return equals; }
            public File getFile1() { return file1; }
            public File getFile2() { return file2; }
        };
    }

    static interface Result {
        boolean areEqual();
        File getFile1();
        File getFile2();
    }
}