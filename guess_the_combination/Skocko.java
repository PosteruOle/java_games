package primer03Kalkulator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import primer01helloJavaFX.XO;

import javax.swing.plaf.ColorUIResource;
import java.util.*;


public class Skocko extends Application {
    private int x=20;
    private int y=20;
    private int x1=20;
    private int y1=20;
    private int count=0;
    private int attemp=1;
    private int hit=0;
    private int miss_place=0;
    private HashSet<Integer> tried=new HashSet<>();
    private List<Integer> guess=new ArrayList<>();
    private int[] solution=new int[4];
    private List<String> quotes=new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Random rand=new Random();
        for(int i=0;i<4;i++){
            solution[i]= rand.nextInt(6)+1;
        }

        quotes.add("The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela\n");
        quotes.add("The way to get started is to quit talking and begin doing. -Walt Disney");
        quotes.add("Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. -Steve Jobs");
        quotes.add("If life were predictable it would cease to be life, and be without flavor. -Eleanor Roosevelt");
        quotes.add("If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough. -Oprah Winfrey");
        quotes.add("If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. -James Cameron");
        quotes.add("Life is what happens when you're busy making other plans. -John Lennon");
        quotes.add("The best and most beautiful things in the world cannot be seen or even touched — they must be felt with the heart. -Helen Keller");
        quotes.add("It is during our darkest moments that we must focus to see the light. -Aristotle");
        quotes.add("Whoever is happy will make others happy too. -Anne Frank");
        quotes.add("Do not go where the path may lead, go instead where there is no path and leave a trail. -Ralph Waldo Emerson");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10,10,10,10));
        Button btCheck = new Button("Check solution!");
        Button btClear = new Button("Clear!");
        Button btGiveQuote = new Button("Give me a random quote!");
        TextArea space = new TextArea();

        Button btRed = new Button("RED");
        Button btBlue = new Button("BLUE");
        Button btBlack = new Button("BLACK");
        Button btGreen = new Button("GREEN");
        Button btPink = new Button("PINK");
        Button btOrange = new Button("ORANGE");
        HBox colors=new HBox(10);

        Label lblTekst = new Label("");
        btCheck.setAlignment(Pos.BASELINE_CENTER);
        btClear.setAlignment(Pos.BASELINE_CENTER);

        Canvas canvas1 = new Canvas(200, 200);
        GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        Canvas canvas2 = new Canvas(200, 200);
        GraphicsContext gc2 = canvas2.getGraphicsContext2D();
        gc1.setFill(Color.ORANGE);


        colors.getChildren().addAll(btRed, btBlack, btBlue, btPink, btGreen, btOrange);
        root.getChildren().addAll(colors, canvas1, btCheck, canvas2, btClear, btGiveQuote, space);

        btGiveQuote.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Random random=new Random();
                int index= random.nextInt(10);
                space.setText(quotes.get(index));

            }
        });
        btClear.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                gc1.clearRect(0,0,200,200);
                gc2.clearRect(0,0,200,200);
            }
        });
        /*
        * RED = 1
        * BLACK = 2
        * BLUE = 3
        * PINK = 4
        * GREEN = 5
        * ORANGE = 6
        * */
        //btUnesi.setOnAction();
        btCheck.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                // Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
                // na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.

                for(int i=0;i<hit;i++){
                    gc2.setFill(Color.RED);
                    gc2.fillRect(x1, y1, 10,10);
                    x1+=20;
                }

                for(int i=0;i<miss_place;i++){
                    gc2.setFill(Color.YELLOW);
                    gc2.fillRect(x1, y1, 10,10);
                    x1+=20;
                }
                x1=20;
                y1+=20;
                if(hit==4){
                    Win end = new Win(solution);
                    try {
                        end.start(stage);
                    } catch (Exception e) {
                        System.out.println("Greska pri otvaranju poruke!\n");
                        System.exit(1);
                    }
                    System.exit(0);
                }
                hit=0;
                miss_place=0;
                guess.clear();
                tried.clear();
            }
        });

        btRed.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                // Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
                // na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.

                gc1.setFill(Color.RED);
                gc1.fillRect(x, y, 10, 10);
                x+=20;
                guess.add(1);
                /*
                for(int i=0;i<4;i++){
                    if(count==i && solution[i]==1 && !tried.contains(i)){
                        hit++;
                        tried.add(i);
                        break;
                    } else if(solution[i]==1 && !tried.contains(i)){
                        miss_place++;
                        tried.add(i);
                        break;
                    }

                }

                 */
                count++;
                if(count==4){
                    attemp++;
                    haveYouHitSomething();
                    if(attemp==8){
                        Error error=new Error();
                        try {
                            error.start(stage);
                        } catch (Exception e) {
                            System.out.println("Neuspesno pokretanje poruke!\n");
                            System.exit(1);
                        }

                    }
                    count=0;
                    y+=20;
                    x=20;
                }
                //btRed.setDisable(true);

                // Na labelu postavljamo tekst.

            }
        });

        btBlack.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                // Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
                // na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.

                gc1.setFill(Color.BLACK);
                gc1.fillRect(x, y, 10, 10);
                x+=20;
                guess.add(2);
                /*
                for(int i=0;i<4;i++){
                    if(count==i && solution[i]==2 && !tried.contains(i)){
                        hit++;
                        tried.add(i);
                        break;
                    } else if(solution[i]==2 && !tried.contains(i)){
                        miss_place++;
                        tried.add(i);
                        break;
                    }

                }
                 */
                count++;
                if(count==4){
                    haveYouHitSomething();
                    attemp++;
                    if(attemp==8){
                        Error error=new Error();
                        try {
                            error.start(stage);
                        } catch (Exception e) {
                            System.out.println("Neuspesno pokretanje poruke!\n");
                            System.exit(1);
                        }

                    }
                    count=0;
                    y+=20;
                    x=20;
                }

                // Na labelu postavljamo tekst.

            }
        });

        btPink.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                // Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
                // na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.

                gc1.setFill(Color.PINK);
                gc1.fillRect(x, y, 10, 10);
                x+=20;
                guess.add(4);
                /*
                for(int i=0;i<4;i++){
                    if(count==i && solution[i]==4 && !tried.contains(i)){
                        hit++;
                        tried.add(i);
                        break;
                    } else if(solution[i]==4 && !tried.contains(i)){
                        miss_place++;
                        tried.add(i);
                        break;
                    }

                }
                */
                count++;
                if(count==4){
                    haveYouHitSomething();
                    attemp++;
                    if(attemp==8){
                        Error error=new Error();
                        try {
                            error.start(stage);
                        } catch (Exception e) {
                            System.out.println("Neuspesno pokretanje poruke!\n");
                            System.exit(1);
                        }

                    }
                    count=0;
                    y+=20;
                    x=20;
                }
                //btRed.setDisable(true);

                // Na labelu postavljamo tekst.

            }
        });
        btOrange.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                // Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
                // na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.

                gc1.setFill(Color.ORANGE);
                gc1.fillRect(x, y, 10, 10);
                x+=20;
                guess.add(6);
                /*
                for(int i=0;i<4;i++){
                    if(count==i && solution[i]==6 && !tried.contains(i)){
                        hit++;
                        tried.add(i);
                        break;
                    } else if(solution[i]==6 && !tried.contains(i)){
                        miss_place++;
                        tried.add(i);
                        break;
                    }

                }
                 */
                count++;
                if(count==4){
                    haveYouHitSomething();
                    attemp++;
                    if(attemp==8){
                        Error error=new Error();
                        try {
                            error.start(stage);
                        } catch (Exception e) {
                            System.out.println("Neuspesno pokretanje poruke!\n");
                            System.exit(1);
                        }

                    }
                    count=0;
                    y+=20;
                    x=20;
                }
                //btRed.setDisable(true);

                // Na labelu postavljamo tekst.

            }
        });
        btGreen.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                // Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
                // na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.

                gc1.setFill(Color.GREEN);
                gc1.fillRect(x, y, 10, 10);
                x+=20;
                guess.add(5);
                /*
                for(int i=0;i<4;i++){
                    if(count==i && solution[i]==5 && !tried.contains(i)){
                        hit++;
                        tried.add(i);
                        break;
                    } else if(solution[i]==5 && !tried.contains(i)){
                        miss_place++;
                        tried.add(i);
                        break;
                    }

                }
                */
                count++;
                if(count==4){
                    haveYouHitSomething();
                    attemp++;
                    if(attemp==8){
                        Error error=new Error();
                        try {
                            error.start(stage);
                        } catch (Exception e) {
                            System.out.println("Neuspesno pokretanje poruke!\n");
                            System.exit(1);
                        }

                    }
                    count=0;
                    y+=20;
                    x=20;
                }
                //btRed.setDisable(true);

                // Na labelu postavljamo tekst.

            }
        });
        btBlue.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                // Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
                // na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.

                gc1.setFill(Color.BLUE);
                gc1.fillRect(x, y, 10, 10);
                x+=20;
                guess.add(3);
                /*
                for(int i=0;i<4;i++){
                    if(count==i && solution[i]==3 && !tried.contains(i)){
                        hit++;
                        tried.add(i);
                        break;
                    } else if(solution[i]==3 && !tried.contains(i)){
                        miss_place++;
                        tried.add(i);
                        break;
                    }

                }
                 */
                count++;
                if(count==4){
                    haveYouHitSomething();
                    attemp++;
                    if(attemp==8){
                        Error error=new Error();
                        try {
                            error.start(stage);
                        } catch (Exception e) {
                            System.out.println("Neuspesno pokretanje poruke!\n");
                            System.exit(1);
                        }

                    }
                    count=0;
                    y+=20;
                    x=20;
                }
                //btRed.setDisable(true);

                // Na labelu postavljamo tekst.

            }
        });


        Scene scene = new Scene(root, 600, 600);

        // Napravljenu scenu postavljamo na pozornicu.
        stage.setScene(scene);
        
        scene.setFill(Color.RED);
        
        // Dajemo nasoj predstavi ime.
        stage.setTitle("Guess the combination!");

        // Otvaramo zavesu.
        stage.show();
    }

    private void haveYouHitSomething() {
        hit=0;
        miss_place=0;
        HashSet<Integer> help=new HashSet<>();

        for(int i=0;i<4;i++){
            if(solution[i]==guess.get(i)) {
                hit++;
                help.add(i);
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(!help.contains(i) && guess.get(i)==solution[j]) {
                    miss_place++;
                    help.add(i);
                }

            }
        }
    }
}
