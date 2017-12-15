
package services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    private String emailAddress;
    private String emailPassword;
    private Properties props;
    private Session session;

    public EmailService() {
        emailAddress = "v.map.app";
        emailPassword = "vmap123456";
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    private void startConnection() {
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddress, emailPassword);
            }
        });
    }

    private void terminateConnection() {
        session = null;
    }

    private String prepareVerificationEmailInHTML(String userFullName, String verificationCode) {
        return "<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #FFFFFF\">\n"
                + "  <style type=\"text/css\" id=\"media-query-bodytag\">\n"
                + "    @media (max-width: 520px) {\n"
                + "      .block-grid {\n"
                + "        min-width: 320px!important;\n"
                + "        max-width: 100%!important;\n"
                + "        width: 100%!important;\n"
                + "        display: block!important;\n"
                + "      }\n"
                + "\n"
                + "      .col {\n"
                + "        min-width: 320px!important;\n"
                + "        max-width: 100%!important;\n"
                + "        width: 100%!important;\n"
                + "        display: block!important;\n"
                + "      }\n"
                + "\n"
                + "        .col > div {\n"
                + "          margin: 0 auto;\n"
                + "        }\n"
                + "\n"
                + "      img.fullwidth {\n"
                + "        max-width: 100%!important;\n"
                + "      }\n"
                + "    }\n"
                + "  </style>\n"
                + "  <!--[if IE]><div class=\"ie-browser\"><![endif]-->\n"
                + "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n"
                + "  <table class=\"nl-container\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #FFFFFF;width: 100%\" cellpadding=\"0\" cellspacing=\"0\">\n"
                + "	<tbody>\n"
                + "	<tr style=\"vertical-align: top\">\n"
                + "		<td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n"
                + "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #FFFFFF;\"><![endif]-->\n"
                + "\n"
                + "    <div style=\"background-color:transparent;\">\n"
                + "      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\n"
                + "        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n"
                + "          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\n"
                + "\n"
                + "              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\n"
                + "            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\n"
                + "              <div style=\"background-color: transparent; width: 100% !important;\">\n"
                + "              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                    <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">\n"
                + "  <!--[if (mso)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px;padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td><![endif]-->\n"
                + "  <div align=\"center\"><div style=\"border-top: 0px solid transparent; width:100%; line-height:0px; height:0px; font-size:0px;\">&#160;</div></div>\n"
                + "  <!--[if (mso)]></td></tr></table></td></tr></table><![endif]-->\n"
                + "</div>\n"
                + "\n"
                + "                  \n"
                + "              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n"
                + "        </div>\n"
                + "      </div>\n"
                + "    </div>    <div style=\"background-image:url('images/sayagata-200px.gif');background-position:top center;background-repeat:repeat;;background-color:transparent;\">\n"
                + "      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\n"
                + "        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n"
                + "          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-image:url('images/sayagata-200px.gif');background-position:top center;background-repeat:repeat;;background-color:transparent\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\n"
                + "\n"
                + "              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:15px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\n"
                + "            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\n"
                + "              <div style=\"background-color: transparent; width: 100% !important;\">\n"
                + "              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:15px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 30px; padding-bottom: 5px;\"><![endif]-->\n"
                + "<div style=\"font-family:'Montserrat', 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Tahoma, sans-serif;line-height:120%;color:#555555; padding-right: 10px; padding-left: 10px; padding-top: 30px; padding-bottom: 5px;\">	\n"
                + "	<div style=\"font-size:12px;line-height:14px;font-family:Montserrat, 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Tahoma, sans-serif;color:#555555;text-align:left;\"><p style=\"margin: 0;font-size: 12px;line-height: 14px;text-align: center\"><span style=\"font-size: 48px; line-height: 57px;\"><strong><span style=\"line-height: 57px; font-size: 48px;\">last step to v.map</span></strong></span></p></div>	\n"
                + "</div>\n"
                + "<!--[if mso]></td></tr></table><![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                  \n"
                + "                    <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 15px; padding-bottom: 20px;\">\n"
                + "  <!--[if (mso)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px;padding-left: 10px; padding-top: 15px; padding-bottom: 20px;\"><table width=\"15%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td><![endif]-->\n"
                + "  <div align=\"center\"><div style=\"border-top: 10px solid #66C7E5; width:15%; line-height:10px; height:10px; font-size:10px;\">&#160;</div></div>\n"
                + "  <!--[if (mso)]></td></tr></table></td></tr></table><![endif]-->\n"
                + "</div>\n"
                + "\n"
                + "                  \n"
                + "                  \n"
                + "                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 5px; padding-bottom: 10px;\"><![endif]-->\n"
                + "<div style=\"font-family:'Montserrat', 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Tahoma, sans-serif;line-height:120%;color:#555555; padding-right: 10px; padding-left: 10px; padding-top: 5px; padding-bottom: 10px;\">	\n"
                + "	<div style=\"font-size:12px;line-height:14px;font-family:Montserrat, 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Tahoma, sans-serif;color:#555555;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\"><span style=\"font-size: 20px; line-height: 24px;\"><img src =\"http://mertdy.com/mailservice.gif\"><br><strong>Dear " + userFullName + ",</strong> </span><br></p></div>	\n"
                + "</div>\n"
                + "<!--[if mso]></td></tr></table><![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                  \n"
                + "                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 25px; padding-left: 25px; padding-top: 5px; padding-bottom: 20px;\"><![endif]-->\n"
                + "<div style=\"font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:180%;color:#555555; padding-right: 25px; padding-left: 25px; padding-top: 5px; padding-bottom: 20px;\">	\n"
                + "	<div style=\"font-size:12px;line-height:22px;color:#555555;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 25px;text-align: center\"><span style=\"font-size: 16px; line-height: 28px;\">We are willing to see you among us. Completion of your registration is just one step ahead that needs the following code to be entered on v.map</span></p></div>	\n"
                + "</div>\n"
                + "<!--[if mso]></td></tr></table><![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                  \n"
                + "                    \n"
                + "<div align=\"center\" class=\"button-container center\" style=\"padding-right: 10px; padding-left: 10px; padding-top:0px; padding-bottom:30px;\">\n"
                + "  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top:0px; padding-bottom:30px;\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:50px; v-text-anchor:middle; width:96px;\" arcsize=\"6%\" strokecolor=\"#66C7E5\" fillcolor=\"#66C7E5\"><w:anchorlock/><center style=\"color:#ffffff; font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif; font-size:18px;\"><![endif]-->\n"
                + "    <div style=\"color: #ffffff; background-color: #66C7E5; border-radius: 3px; -webkit-border-radius: 3px; -moz-border-radius: 3px; max-width: 96px; width: 56px;width: auto; border-top: 0px solid transparent; border-right: 0px solid transparent; border-bottom: 4px solid #59B7E0; border-left: 0px solid transparent; padding-top: 5px; padding-right: 20px; padding-bottom: 5px; padding-left: 20px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; text-align: center; mso-border-alt: none;\">\n"
                + "      <span style=\"line-height:24px;font-size:12px;\"><span style=\"font-size: 18px; line-height: 36px;\"><b>" + verificationCode + "</b></span></span>\n"
                + "    </div>\n"
                + "  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\n"
                + "</div>\n"
                + "\n"
                + "                  \n"
                + "              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n"
                + "        </div>\n"
                + "      </div>\n"
                + "    </div>    <div style=\"background-color:#F9F9F9;\">\n"
                + "      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\n"
                + "        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n"
                + "          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#F9F9F9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\n"
                + "\n"
                + "              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\n"
                + "            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\n"
                + "              <div style=\"background-color: transparent; width: 100% !important;\">\n"
                + "              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><![endif]-->\n"
                + "<div style=\"font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;color:#66C7E5; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">	\n"
                + "	<div style=\"font-size:12px;line-height:14px;color:#66C7E5;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\"><span style=\"font-size: 16px; line-height: 19px; color: rgb(102, 199, 229);\"><strong>v.map</strong></span></p></div>	\n"
                + "</div>\n"
                + "<!--[if mso]></td></tr></table><![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                  \n"
                + "                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><![endif]-->\n"
                + "<div style=\"font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;color:#555555; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">	\n"
                + "	<div style=\"font-size:12px;line-height:14px;color:#555555;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\"><strong>© 2017 v.map Inc.</strong> All rights reserved</p></div>	\n"
                + "</div>\n"
                + "<!--[if mso]></td></tr></table><![endif]-->\n"
                + "\n"
                + "                  \n"
                + "              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n"
                + "        </div>\n"
                + "      </div>\n"
                + "    </div>    <div style=\"background-color:#F9F9F9;\">\n"
                + "      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\n"
                + "        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n"
                + "          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#F9F9F9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\n"
                + "\n"
                + "              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:15px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\n"
                + "            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\n"
                + "              <div style=\"background-color: transparent; width: 100% !important;\">\n"
                + "              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:15px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\n"
                + "\n"
                + "                  \n"
                + "                    <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">\n"
                + "  <!--[if (mso)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px;padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td><![endif]-->\n"
                + "  <div align=\"center\"><div style=\"border-top: 0px solid transparent; width:100%; line-height:0px; height:0px; font-size:0px;\">&#160;</div></div>\n"
                + "  <!--[if (mso)]></td></tr></table></td></tr></table><![endif]-->\n"
                + "</div>\n"
                + "\n"
                + "                  \n"
                + "              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n"
                + "        </div>\n"
                + "      </div>\n"
                + "    </div>   <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
                + "		</td>\n"
                + "  </tr>\n"
                + "  </tbody>\n"
                + "  </table>\n"
                + "  <!--[if (mso)|(IE)]></div><![endif]-->\n"
                + "\n"
                + "</body>";

    }

    private boolean sendEmail(String recieverEmail, String mailSubject, String contentOfEmail) {

        boolean success = true;

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(emailAddress + "@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recieverEmail));
            message.setSubject(mailSubject);
            message.setContent(contentOfEmail, "text/html; charset=utf-8");
            Transport.send(message);
            System.out.println("Email has been sent successfully!");

        } catch (MessagingException e) {
            System.out.println("Failed to send email!");
            success = false;
        }

        return success;

    }

    public boolean sendVerificationEmail(String userFullName, String userEmail, String verificationCode) {

        startConnection();
        boolean result = sendEmail(userEmail, "Verification for v.map", prepareVerificationEmailInHTML(userFullName, verificationCode));
        terminateConnection();
        return result;
    }

    public static void main(String args[]) {
        EmailService email = new EmailService();
        boolean bool = email.sendVerificationEmail("Müc SA", "ahmetsaidtekkurt@gmail.com", "11111");
    }

}
