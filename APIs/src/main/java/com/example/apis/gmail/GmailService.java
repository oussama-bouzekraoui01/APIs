package com.example.apis.gmail;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

@Service
public class GmailService {

    //    private static final String APPLICATION_NAME = "Virtual Assistant";
//    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
//    private static final String TOKENS_DIRECTORY_PATH = "C:\\Users\\Oussama BOUZEKRAOUI\\Documents";
//    private static final String CREDENTIALS_FILE_PATH = "C:\\Users\\Oussama BOUZEKRAOUI\\Downloads\\code_secret_client_466380275884-qgqa26am8knc727tfs9mc9oonm3l0v3n.apps.googleusercontent.com.json";
//    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_LABELS);
    private final JavaMailSender javaMailSender;


    @Autowired
    public GmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendMessage(GmailParam gmailParam) throws MessagingException {

//        System.out.println("sending email");
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom("oussamabouzekraoui01@gmail.com");
//        simpleMailMessage.setTo(gmailParam.getTo());
//        simpleMailMessage.setSubject(gmailParam.getTopic());
//        simpleMailMessage.setText(gmailParam.getBody());


//        Properties props = new Properties();
//        Session session = Session.getDefaultInstance(props, null);
//
//        MimeMessage email = new MimeMessage(session);
//
//        email.setFrom(new InternetAddress("oussamabouzekraoui01@gmail.com"));
//
//        email.addRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(gmailParam.getTo()));
//        email.setSubject(gmailParam.getTopic());
//
//        MimeBodyPart mimeBodyPart = new MimeBodyPart();
//        mimeBodyPart.setContent(gmailParam.getBody(), "text/plain");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(mimeBodyPart);
//
//        File file = new File(gmailParam.getPath());
//
//        mimeBodyPart = new MimeBodyPart();
//        DataSource source = new FileDataSource(file);
//        mimeBodyPart.setDataHandler(new DataHandler(source));
//        mimeBodyPart.setFileName(file.getName());
//
//        multipart.addBodyPart(mimeBodyPart);
//        email.setContent(multipart);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("oussamabouzekraoui01@gmail.com");
        mimeMessageHelper.setTo(gmailParam.getTo());
        mimeMessage.setText(gmailParam.getBody());
        mimeMessage.setSubject(gmailParam.getTopic());

        FileSystemResource fileSystemResource = new FileSystemResource(new File(gmailParam.getPath()));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);



        javaMailSender.send(mimeMessage);
        System.out.println("email sent");
//    }


//    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
//
//        File file = new File(CREDENTIALS_FILE_PATH);
//
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new FileReader(file));
//
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                .setAccessType("offline")
//                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8081).build();
//        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
//        //returns an authorized Credential object.
//        return credential;
//    }
//
//    public static void main(String... args) throws IOException, GeneralSecurityException {
//
//        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//
//
//        String user = "me";
//        ListLabelsResponse listResponse = service.users().labels().list(user).execute();
//        List<Label> labels = listResponse.getLabels();
//        if (labels.isEmpty()) {
//            System.out.println("No labels found.");
//        } else {
//            System.out.println("Labels:");
//            for (Label label : labels) {
//                System.out.printf("- %s\n", label.getName());
//            }
//        }
//    }

    }
}