package com.pro.utils;

import java.io.File;

import org.hyperic.sigar.Sigar;

import com.google.common.io.Resources;

public class SigarUtils {
    private static class SigarUtilHolder {
        private static final SigarUtils INSTANCE = new SigarUtils();
        private static final Sigar Sigar = new Sigar();
    }

    private SigarUtils() {
        try {
            String file = Resources.getResource("sigar/.sigar_shellrc").getFile();
            File classPath = new File(file).getParentFile();
            String path = System.getProperty("java.library.path");
            if (OsCheck.getOperatingSystemType() == OsCheck.OSType.Windows) {
                path += ";" + classPath.getCanonicalPath();
            } else {
                path += ":" + classPath.getCanonicalPath();
            }
            System.setProperty("java.library.path", path);
            System.out.println(path);
        } catch (Exception e) {
        }
    }

    public static final Sigar getInstance() {
        return SigarUtilHolder.Sigar;
    }

    public static final SigarUtils getSigarUtilInstance() {
        return SigarUtilHolder.INSTANCE;
    }
}