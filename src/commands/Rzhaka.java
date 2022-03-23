package commands;

import dao.RouteDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Класс команды RZHAKA, предназначенный для мемного троллинга
 */
public class Rzhaka extends ACommands{

    public void execute(RouteDAO routeDAO) {
        while (true) {
            try {
                File file = new File("C:\\Users\\Софья\\Downloads\\trollingAlexEgichin.jpg");
                BufferedImage bufferedImage = ImageIO.read(file);

                ImageIcon imageIcon = new ImageIcon(bufferedImage);
                JFrame jFrame = new JFrame();

                jFrame.setLayout(new FlowLayout());

                jFrame.setSize(700, 700);
                JLabel jLabel = new JLabel();
                //jLabel.setText("ВНИМАНИЕ!! ОТБОЙ ПОЖАРНОЙ ТРЕВОГИ ");
                jLabel.setIcon(imageIcon);
                jFrame.add(jLabel);
                jFrame.setVisible(true);

                jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("но это только первая часть подарка. чтобы увидеть вторую введите cringe");
            /*while (true) {
                if (Objects.equals(sc.nextLine(), "cringe")) {
                    try {
                        File file = new File("C:\\Users\\Софья\\OneDrive\\Изображения\\a.jpg");
                        BufferedImage bufferedImage = ImageIO.read(file);
                        ImageIcon imageIcon = new ImageIcon(bufferedImage);
                        JFrame jFrame = new JFrame();

                        jFrame.setLayout(new FlowLayout());

                        jFrame.setSize(700, 200);
                        JLabel jLabel = new JLabel();

                        jLabel.setIcon(imageIcon);
                        jFrame.add(jLabel);
                        jFrame.setVisible(true);

                        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("зачем команду ломаешь...");
                    System.out.println("для просмотра второй части подарка введите cringe");
                }
            }*/
    }

}
