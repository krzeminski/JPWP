package com.example.pleasework;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;
import static android.app.Notification.VISIBILITY_PUBLIC;
import static android.graphics.Bitmap.createBitmap;

public class NotificationsActivity extends AppCompatActivity {

    private int messageCount = 25;
    //choose your own
    private final String CHANNEL_ID = "CHANNEL_ID";
    private final String CHANNEL_ID_EXPANDABLE = "CHANNEL_ID_EXPANDABLE";
    private final String CHANNEL_ID_GROUPED = "CHANNEL_ID_GROUPED";
    private final int NOTIFICATION_ID = 420;
    private final int NOTIFICATION_ID_EXPANDABLE = 421;
    public final String CHANNEL_ID_REPLAY = "personal_notifications";
    public static final int NOTIFICATION_ID_REPLAY = 101;
    public static final String TXT_REPLAY = "text replay";

//    Zadanie 0.
//    Od Androida N aby wyświetlić powiadomienie niezbędny jest do tego kanał, dlatego aby zobaczyć efekty przyszłej pracy zacznij od stworzenia go
//    do tego celu wykorzystaj następujące linijki
//    Stwórz funkcję tworzącą kanały powiadomień. Niech przyjmuje ona 3 argumenty: nazwę i id channelu oraz poziom ważności (CharSequence, String, int)
//      NotificationChannel channel = new NotificationChannel(id, name, importance);
//      NotificationManager notificationManager = getSystemService(NotificationManager.class);
//      notificationManager.createNotificationChannel(channel);
//    Przykładowy kod znajduje się na slajdzie 27. jednak za jego pomocą tworzymy pojedynczy kanał, a nasza funkcja ma pozwalać tworzyć ich więcej

    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            //zadeklaruj zmienne
//            String description = getString(R.string.channel_description);
//            //utwórz kanał
//            channel.setDescription(description);
//            //zarządzaj kanałem
//        }
    }
    private void createNotificationChannel(CharSequence n, String id){
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
       // createNotificationChannel(n, id, importance);
    }


//    Zadanie 1
//      Stwórz proste powiadomienie wyświetlające się na pasku powiadomień.
//      Spraw aby powiadomienie po kliknięciu przenosiło cię w wybrane miejsce w aplikacji
//      Pamiętaj, że każde powiadomienie musi zawierać ikonkę. Ustawia się ją za pomocą setSmallIcon().
//      (wskazówka) Aby stworzyć nową ikonkę możesz kliknąć w dowolnym miejscu project tree prawym przyciskiem myszy i wybrać Vector Asset
//      Spraw aby powiadomienie wyświetlało się na wygaszaczu ekranu
//      (dodatkowe) Dodaj przyciski w powiadomieniu

    public void generateSimpleNotification(View view) {
//        //na początku musimy stworzyć kanał
//        createNotificationChannel(getString(R.string.channel_name),CHANNEL_ID);
//
//        //spraw aby naciśnięcie powiadomienia przenosiło do MainActivity, potrzebny kod znajduje się na slajdzie 30.
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
//
//
//        //zbuduj powiadomienie według wzoru na slajdzie 28. (wskazówka) zamiast pisać "builder.set**();" w każdej linijce możesz nowe metody dodawać po kropce "buidler.setA().setB().setC()...;"
//        builder.setSmallIcon(R.drawable.abc1)    //R.drawable = app/res/drawable/image
//        // pamiętaj o wywołaniu metod związanych z Intentem odpowiedzialnym za przenoszenie nas przy kliknięciu
//
//        //pokaż powiadomienie (slajd 29) użyj zmiennej: NOTIFICATION_ID

    }


//    Zadanie 2.
//    Aby stwórz rozwijane powiadomienie wystarczy wykorzystać funkcję setStyle() podczas kreowania powiadomienia za pomocą NotificationCompat.Builder
//    Umożliwia ona dołączenie do powiadomienia m.in. obrazu bmp, długiego tekstu czy pojedynczych linijek wiadomości
//    Twoim zadaniem będzie stworzenie rozszerzanego powiadomienia na każdy z wymienionych sposobów.
//    Wykorzystaj kod ze slajdu 31 i wpisz go pod każdą opcją (zaczynając ok.25 linijek niżej)

    public void generateExpandableNotification(View view){
        createNotificationChannel(getString(R.string.ex_channel_name),CHANNEL_ID_EXPANDABLE);

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID_EXPANDABLE);
        builder.setSmallIcon(R.drawable.abc1)    //R.drawable = app/res/drawable/image
                .setContentTitle("Expandable Notification")
                .setContentText("This is an expandable notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)           //different types of priority have different options like vibration, sound or led signal
                .setContentIntent(pendingIntent)                            //sets tap action
                .setAutoCancel(true)                                        //notification disappear after being tapped
                .setVisibility(VISIBILITY_PUBLIC);                          //permits to show all content of notification on a lock screen
        ;

//Choose one of the possible option below and uncomment to see effects (ctrl+/)

//        //Option 1 bitmap
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bestofthebest);


//        //Option 2 bigtext
        String subject = getString(R.string.longmsg);

//        //Option 3 line message
//        String messageSnippet1 = "First line";
//        String messageSnippet2 = "Second one";
//        String messageSnippet3 = "You can add a lot of new lines";
//        String messageSnippet4 = "But only up to 6 will be displayed";


//******************
        //part below shows the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID_EXPANDABLE, builder.build());
    }
//    Zadanie 3.
//    Utwórz grupowanie powiadomień
//    Aby to osiągnąć musisz stworzyć co najmniej 3 powiadomienia. Każde z nich powinno należeć do tej samej grupy oraz mieć inne ID.
//    Grupę ustala się za pomocą funkcji .setGroup("nazwagrupy").
//    Trzecie powiadomienie niech posłuży Ci za "powiadomienie sumujące". Poinformuj o tym przez ustawienie .setGroupSummary(true).
//    Do zsumowania powiadomień w grupie wykorzystaj InBoxStyle. Dodaj .addLine("") (<-tyle razy ile powiadomień sumujesz),
//    .setBigContentTitle("You have 2 message") oraz .setSummaryText("user@example.com").
//    Na koniec wywołaj po kolei każde powiadomienie w 2s odstępach czasu

    public void createGroupedNotification(View view){
        createNotificationChannel(getString(R.string.gr_channel_name),CHANNEL_ID_GROUPED);
        //use constant ID for notification used as group summary
        int SUMMARY_ID = 50;
        int emailNotificationId1 = 51;
        int emailNotificationId2 = 52;
        String GROUP_KEY = "com.android.example.WORK_EMAIL";


        Notification newMessageNotification1 =
                new NotificationCompat.Builder(this, CHANNEL_ID_GROUPED)
                        .setSmallIcon(R.drawable.ic_mail_outline_black_24dp)
//                        Wstaw co potrzebne
                        .build();
//      Pamiętaj o drugim powiadomieniu


        Notification summaryNotification =
                new NotificationCompat.Builder(this, CHANNEL_ID_GROUPED)
                        .setContentTitle("Check your post")
                        .setContentText("Two new messages")                         //sets content text to support devices running API level < 24
                        .setSmallIcon(R.drawable.ic_mail_outline_black_24dp)
                        //stwórz informację zbiorczą używając InboxStyle()
                        .setStyle(new NotificationCompat.InboxStyle()
                                //
                                //
                        )
                        //Sprecyzuj do jakiej grupy należy powiadomienie (groupkey)
                        //Daj znać, że to powiadomienie jest powiadomieniem zbiorczym
                        .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        SystemClock.sleep(3000);

        notificationManager.notify(emailNotificationId1, newMessageNotification1);
        //za dwie sekundy wywołaj kolejne powiadomienie, a po nim sumujące
    }

//    Zadanie 4.
//    Stwórz powiadomienie na które można odpowiadać.
//    Aby to osiągnąć utwórz Remote Input dzięki czemu będziesz mógł dodać akcję do swojego powiadomienia.

    public void replayNotification(View view) {
//odkomentuj po zrobieniu zadania 0
        //createNotificationChannel(getString(R.string.re_channel_name),CHANNEL_ID_REPLAY,NotificationManager.IMPORTANCE_MAX);


        Intent landingIntent = new Intent(this, MainActivity.class);
        landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent landingPendingIntent = PendingIntent.getActivity(this, 0,landingIntent ,PendingIntent.FLAG_ONE_SHOT);



        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID_REPLAY);
        builder.setSmallIcon(R.drawable.ic_insert_comment_black_24dp);
        builder.setContentTitle("Replay Notification");
        builder.setContentText("This is a replay notification");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setAutoCancel(true);
        builder.setContentIntent(landingPendingIntent);


        // Na powiadomienia można odpowiadać od Androida N.
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {


            //Konstruktor tej klasy pobiera string, którego system używa jako klucza do wprowadzania tekstu.
            //Później Twoja aplikacja podręczna używa tego klucza, aby pobrać tekst danych wejściowych.
            RemoteInput remoteInput = new RemoteInput.Builder(TXT_REPLAY).setLabel("Replay").build();


            // Utwórz replayIntent który bedzie przenosił cię do RemoteReceiver.class
            // Klasa RemoteReciver odpowiada za wyswietlanie wiadomości wpisanej do powiadomienia


            //Utwór akcję i dołącz objekt RemoteInput do akcji używając metody addRemoteInput().
           // NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_insert_comment_black_24dp,"Replay", replayPendingIntent)./* tu wstaw metodę */.build();


            //Dołącz akcję do powiadomienia za pomocą builder.addAction(action);


        }



        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID_REPLAY,builder.build());
    }





//   Zadanie 5.
//   Notification Badge domyślnie jest zawsze włączone choć nie zawsze jest to potrzebne.
//   Aby wyłączyć pokazywanie powiadomienia po przytrzymaniu ikonki aplikacji ustaw dla danego NotificationChannelu opcję .setShowBadge(false)
//   Możesz też w pewnym stopniu manipulować Badge np. ustawiając dla danego powiadomienia  .setNumber(int) (sprawia że jedno powiadomienie liczy się jako kilka)
//   lub .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL) (zmienia ikonkę)
//   W tym zadaniu wyłącz Notification Badge oraz ustaw wskazane metody dla Simple Notification.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }


}