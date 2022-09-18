package com.bmp.website;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SendEmail", value = "/SendEmail")
public class SendEmail extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    @Override
    public void init() throws ServletException {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String recipient = request.getParameter("email"); //
        String subject = "Message From BMP Website";
        String content = request.getParameter("message");

        String resultMessage = "";
        String message = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "  <title></title>\n" +
                "\n" +
                "  <style type=\"text/css\">\n" +
                "    @media only screen and (min-width: 620px) {\n" +
                "      .u-row {\n" +
                "        width: 600px !important;\n" +
                "      }\n" +
                "\n" +
                "      .u-row .u-col {\n" +
                "        vertical-align: top;\n" +
                "      }\n" +
                "\n" +
                "      .u-row .u-col-100 {\n" +
                "        width: 600px !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media (max-width: 620px) {\n" +
                "      .u-row-container {\n" +
                "        max-width: 100% !important;\n" +
                "        padding-left: 0px !important;\n" +
                "        padding-right: 0px !important;\n" +
                "      }\n" +
                "\n" +
                "      .u-row .u-col {\n" +
                "        min-width: 320px !important;\n" +
                "        max-width: 100% !important;\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "\n" +
                "      .u-row {\n" +
                "        width: calc(100% - 40px) !important;\n" +
                "      }\n" +
                "\n" +
                "      .u-col {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "\n" +
                "      .u-col>div {\n" +
                "        margin: 0 auto;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "    }\n" +
                "\n" +
                "    table,\n" +
                "    tr,\n" +
                "    td {\n" +
                "      vertical-align: top;\n" +
                "      border-collapse: collapse;\n" +
                "    }\n" +
                "\n" +
                "    p {\n" +
                "      margin: 0;\n" +
                "    }\n" +
                "\n" +
                "    .ie-container table,\n" +
                "    .mso-container table {\n" +
                "      table-layout: fixed;\n" +
                "    }\n" +
                "\n" +
                "    * {\n" +
                "      line-height: inherit;\n" +
                "    }\n" +
                "\n" +
                "    a[x-apple-data-detectors='true'] {\n" +
                "      color: inherit !important;\n" +
                "      text-decoration: none !important;\n" +
                "    }\n" +
                "\n" +
                "    table,\n" +
                "    td {\n" +
                "      color: #000000;\n" +
                "    }\n" +
                "\n" +
                "    #u_body a {\n" +
                "      color: #0000ee;\n" +
                "      text-decoration: underline;\n" +
                "    }\n" +
                "  </style>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"clean-body u_body\"\n" +
                "  style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9;color: #000000\">\n" +
                "  <table id=\"u_body\"\n" +
                "    style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\"\n" +
                "    cellpadding=\"0\" cellspacing=\"0\">\n" +
                "    <tbody>\n" +
                "      <tr style=\"vertical-align: top\">\n" +
                "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\"\n" +
                "              style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "              <div\n" +
                "                style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "\n" +
                "                <div class=\"u-col u-col-100\"\n" +
                "                  style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"height: 100%;width: 100% !important;\">\n" +
                "                    <div\n" +
                "                      style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                        width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td\n" +
                "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\"\n" +
                "                              align=\"left\">\n" +
                "\n" +
                "                              <div\n" +
                "                                style=\"color: #afb0c7; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 170%;\"><span\n" +
                "                                    style=\"font-size: 14px; line-height: 23.8px;\">View Email in Browser</span></p>\n" +
                "                              </div>\n" +
                "\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\"\n" +
                "              style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "              <div\n" +
                "                style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "                <div class=\"u-col u-col-100\"\n" +
                "                  style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"height: 100%;width: 100% !important;\">\n" +
                "                    <div\n" +
                "                      style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                        width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td\n" +
                "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:20px;font-family:'Cabin',sans-serif;\"\n" +
                "                              align=\"left\">\n" +
                "\n" +
                "                              <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                                <tr>\n" +
                "                                  <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "\n" +
                "                                    <img align=\"center\" border=\"1\" src=\"https://i.ibb.co/gVX2d1b/bmp-logo-final.png\"\n" +
                "                                      alt=\"Image\" title=\"Image\"\n" +
                "                                      style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: 150px;float: none; border: 3px solid #ffa41b; border-radius: 50%;\" />\n" +
                "                                    <h2 style=\"color: #3d3d3d;\">BMP Software Solutions</h2>\n" +
                "\n" +
                "                                  </td>\n" +
                "                                </tr>\n" +
                "                              </table>\n" +
                "\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\"\n" +
                "              style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "              <div\n" +
                "                style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "\n" +
                "                <div class=\"u-col u-col-100\"\n" +
                "                  style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"height: 100%;width: 100% !important;\">\n" +
                "                    <div\n" +
                "                      style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                        width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td\n" +
                "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:33px 55px;font-family:'Cabin',sans-serif;\"\n" +
                "                              align=\"left\">\n" +
                "\n" +
                "                              <div style=\"line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span\n" +
                "                                    style=\"font-size: 22px; line-height: 35.2px;\">Message From " + name + ", </span></p>\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span\n" +
                "                                    style=\"font-size: 18px; line-height: 28.8px;\">" + content + "</span></p>\n" +
                "                              </div>\n" +
                "\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\"\n" +
                "              style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "              <div\n" +
                "                style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "                <div class=\"u-col u-col-100\"\n" +
                "                  style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"height: 100%;width: 100% !important;\">\n" +
                "                    <div\n" +
                "                      style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                        width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td\n" +
                "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:41px 55px 18px;font-family:'Cabin',sans-serif;\"\n" +
                "                              align=\"left\">\n" +
                "\n" +
                "                              <div\n" +
                "                                style=\"color: #003399; line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span\n" +
                "                                    style=\"font-size: 20px; line-height: 32px;\"><strong>Customer Details</strong></span>\n" +
                "                                </p>\n" +
                "                                <!-- TODO: Mobile -->\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span\n" +
                "                                    style=\"font-size: 16px; line-height: 25.6px; color: #000000;\">" + mobile + "</span></p>\n" +
                "                                <!-- TODO: email -->\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span\n" +
                "                                    style=\"font-size: 16px; line-height: 25.6px; color: #000000;\">" + recipient + "</span>\n" +
                "                                </p>\n" +
                "                              </div>\n" +
                "\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "              <div class=\"u-row\"\n" +
                "                style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #fbc118;\">\n" +
                "                <div\n" +
                "                  style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "                  <div class=\"u-col u-col-100\"\n" +
                "                    style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                    <div style=\"height: 100%;width: 100% !important;\">\n" +
                "                      <div\n" +
                "                        style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                        <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\"\n" +
                "                          cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td\n" +
                "                                style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\"\n" +
                "                                align=\"left\">\n" +
                "\n" +
                "                                <div\n" +
                "                                  style=\"color: #fafafa; line-height: 180%; text-align: center; word-wrap: break-word;\">\n" +
                "                                  <p style=\"font-size: 14px; line-height: 180%;\"><span\n" +
                "                                      style=\"font-size: 16px; line-height: 28.8px; color: #3d3d3d;\">Copyrights &copy;\n" +
                "                                      BMP Software Solutions. All Rights\n" +
                "                                      Reserved</span></p>\n" +
                "                                </div>\n" +
                "\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        try {
            EmailUtility.sendEmail(host, port, user, pass, user, subject, message, recipient);
            resultMessage = "success";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            response.getWriter().write(resultMessage);
        }
    }
}
