package com.mousika.tool.util;

public class PathUtil {
    
    public static String pack2Path(String pack){
        System.out.println(pack);
        String path = pack.replace(".", "/");
        return path;
    }

    public static void main(String[] args) {
        pack2Path("com.mousika.user.domain");
    }

}
