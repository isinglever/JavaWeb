package org.study;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get file path
        String filePath = "D:\\ideaProjects\\JavaWeb\\Download\\src\\main\\resources\\Music Album.jpg";
        System.out.println(filePath);
        //get filename
        String name = filePath.substring(filePath.lastIndexOf("\\") + 1);
        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition", "attachment; filename=" + name);

        FileInputStream fileInputStream = new FileInputStream(filePath);
        int len = 0;
        byte[] buffer = new byte[1024];
        //ServletOutputStream getOutputStream = new resp.getOutputStream();
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len=fileInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
