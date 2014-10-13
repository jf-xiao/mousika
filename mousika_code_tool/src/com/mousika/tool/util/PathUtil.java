package com.mousika.tool.util;

/**
 * 路径工具类
 * @author xiaojf 294825811@qq.com
 */
public class PathUtil {
    /**
     * 将包路径转换成文件路径,如 com.mousika.user -> com/mousika/user
     * @param pack
     * @return
     * @author xiaojf 294825811@qq.com
     */
    public static String pack2Path(String pack){
        String path = pack.replace(".", "/");
        return path;
    }

/*    public static void main(String[] args) {
        pack2Path("com.mousika.user.domain");
    }*/

}
