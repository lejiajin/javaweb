package com.study.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String downloadFileName="2.jpg";
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition","attachment; filename="+downloadFileName);

        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream,outputStream);

    }
}
