package com.tang.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Sweetie77
 * Created: 2019/8/28
 */
public class ResponseTools {
    public void OK(HttpServletResponse resp,Object data) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/javascript");

        PrintWriter print= resp.getWriter();

        print.write(ok);
        print.flush();
    }


}
