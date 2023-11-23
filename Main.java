package proj;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;

public class Main {
  
  public static String sameCharacter(String chr, int occurences) {
     String l = "";
     for (int i = 0; i < occurences; ++i) {
     l += chr;
     }
  return l;
  }

  public static String col(int colorNb) {
    return "\u001B[" + colorNb + "m";
  }

  public static void lineOfCreatures(int creaturesNum, String creaturesSpecies) {
    String leftPart = col(32) + "▒▒" + col(33) + "██" + col(0);
    String rightPart = col(33) + "██" + col(32) +"▒▒" + col(0);
    
    if (creaturesNum == 1) {
      System.out.println(leftPart + sameCharacter(" ", 4) + creaturesSpecies + sameCharacter(" ", 16) + rightPart);
    }

    else if (creaturesNum == 2) {
      System.out.println(leftPart + sameCharacter(" ", 4) + creaturesSpecies + sameCharacter(" ", 2) + creaturesSpecies + sameCharacter(" ", 12) + rightPart);
    }

    else if (creaturesNum == 3) {
      System.out.println(leftPart + sameCharacter(" ", 4) + creaturesSpecies + sameCharacter(" ", 2) + creaturesSpecies + sameCharacter(" ", 2) + creaturesSpecies + sameCharacter(" ", 8) + rightPart);
    }

    else if (creaturesNum == 4) {
      System.out.println(leftPart + sameCharacter(" ", 4) + creaturesSpecies + sameCharacter(" ", 2) + creaturesSpecies + sameCharacter(" ", 2) + creaturesSpecies + sameCharacter(" ", 2) + creaturesSpecies + sameCharacter(" ", 4) + rightPart);
    }

    System.out.println(leftPart + sameCharacter(" ", 22) + rightPart);
  }
  
  public static void displayZoo(FantasticZoo obj) {
    String leftPart = col(32) + "▒▒" + col(33) + "██" + col(0);
    String rightPart = col(33) + "██" + col(32) +"▒▒" + col(0);
    Dictionary<String, String> creaturesEmojis = new Hashtable<>();
    creaturesEmojis.put("lycanthrope", "🐺");
    creaturesEmojis.put("licorne", "🦄");
    creaturesEmojis.put("nymphe", "👩");
    creaturesEmojis.put("kraken", "🦑");
    creaturesEmojis.put("sirène", "🐟");
    creaturesEmojis.put("mégalodon", "🦈");
    creaturesEmojis.put("phénix", "🐦");
    creaturesEmojis.put("dragon", "🐉");

    System.out.println(sameCharacter("█", 30));
    for (int i = 0; i < obj.getEnclosures().size(); ++i) {
      System.out.println(col(32) + sameCharacter("▒", 30) + col(0));
      System.out.println(leftPart + col(33) + sameCharacter("█", 22) + rightPart);
      System.out.println(leftPart + col(33) + sameCharacter("▉", 22) + rightPart);
      System.out.println(leftPart + sameCharacter(" ", 22) + rightPart);

      String currentSpecies = creaturesEmojis.get(obj.getEnclosures().get(i).getCreatures().get(0).getSpeciesName());

      int fourCreaturesLinesNb = (int) Math.ceil(obj.getEnclosures().get(i).getCreatures().size() / 4);

      int lastLine = (int) Math.ceil(obj.getEnclosures().get(i).getCreatures().size() % 4);
      
      for (int j = 0; j < fourCreaturesLinesNb; ++j) {
        lineOfCreatures(4, currentSpecies);
      }
      
      if (lastLine == 1 || lastLine == 2 || lastLine == 3) {
        lineOfCreatures(lastLine, currentSpecies);
      }
      
      System.out.println(leftPart + col(33) + sameCharacter("█", 22) + rightPart);
      System.out.println(col(32) + "▒▒" + col(33) + sameCharacter("▉", 26) + col(32) + "▒▒" + col(0));
      System.out.println(col(32) + sameCharacter("▒", 30) + col(0));
    }
  }

  public static void displayCharacteristics(FantasticZoo zooObj, Enclosure enclosureObj, Creature creatureObj, String category) {
    if (category == "ZOO") {
      System.out.println(
        sameCharacter("█", 30) + "\n" +
        "█ > Zoo <" + sameCharacter(" ", 20) + "█" + "\n" +
        "█   Maître" + sameCharacter(" ", 19) + "█" + "\n" +
        "█   Enclos" + sameCharacter(" ", 19) + "█" + "\n" +
        "█   Créature" + sameCharacter(" ", 17) + "█" + "\n" +
        "█   Action" + sameCharacter(" ", 19) + "█" + "\n" +
        sameCharacter("█", 30) + "\n" +
        "█-ZOO" + sameCharacter("-", 24) + "█\n" +
        "█ Nom : " + zooObj.getZooName() + "\n" +
        "█ Maître : " + zooObj.getMaster().getMasterName() + "\n" +
        "█ Nombre max enclos : " + zooObj.getMaxEnclosuresNb() + "\n" +
        "█ Enclos existants : " + zooObj.getEnclosures().size() + "\n" +
        sameCharacter("█", 30));
    }
    if (category == "MAÎTRE") {
      System.out.println(
        sameCharacter("█", 30) + "\n" +
        "█   Zoo" + sameCharacter(" ", 22) + "█" + "\n" +
        "█ > Maître <" + sameCharacter(" ", 17) + "█" + "\n" +
        "█   Enclos" + sameCharacter(" ", 19) + "█" + "\n" +
        "█   Créature" + sameCharacter(" ", 17) + "█" + "\n" +
        "█   Action" + sameCharacter(" ", 19) + "█" + "\n" +
        sameCharacter("█", 30) + "\n" +
        "█-MAÎTRE" + sameCharacter("-", 21) + "█\n" +
        "█ Nom : " + zooObj.getMaster().getMasterName() + "\n" +
        "█ Sexe : " + zooObj.getMaster().getGender() + "\n" +
        "█ Âge : " + zooObj.getMaster().getAge() + "\n" +
        sameCharacter("█", 30));
    }
    if (category == "ENCLOS") {
      System.out.println(
        sameCharacter("█", 30) + "\n" +
        "█   Zoo" + sameCharacter(" ", 22) + "█" + "\n" +
        "█   Maître" + sameCharacter(" ", 19) + "█" + "\n" +
        "█ > Enclos <" + sameCharacter(" ", 17) + "█" + "\n" +
        "█   Créature" + sameCharacter(" ", 17) + "█" + "\n" +
        "█   Action" + sameCharacter(" ", 19) + "█" + "\n" +
        sameCharacter("█", 30) + "\n" +
        "█-ENCLOS" + sameCharacter("-", 21) + "█\n" +
        "█ Nom : " + enclosureObj.getEnclosureName() + "\n" +
        "█ Superficie : " + enclosureObj.getArea() + " m²" + "\n" +
        "█ Nombre max créatures : " + enclosureObj.getMaxCreaturesNb() + "\n" +
        "█ Nombre créatures : " + enclosureObj.getCreatures().size() + "\n" +
        "█ Créatures : " + "\n" +
        "█ Degré propreté : " + enclosureObj.getCleanliness() + "\n" +
        sameCharacter("█", 30));
    }
    if (category == "CRÉATURE") {
      System.out.println(
        sameCharacter("█", 30) + "\n" +
        "█   Zoo" + sameCharacter(" ", 22) + "█" + "\n" +
        "█   Maître" + sameCharacter(" ", 19) + "█" + "\n" +
        "█   Enclos" + sameCharacter(" ", 19) + "█" + "\n" +
        "█ > Créature <" + sameCharacter(" ", 15) + "█" + "\n" +
        "█   Action" + sameCharacter(" ", 19) + "█" + "\n" +
        sameCharacter("█", 30) + "\n" +
        "█-CRÉATURE" + sameCharacter("-", 19) + "█\n" +
        "█ Nom espèce : " + creatureObj.getSpeciesName() + "\n" +
        "█ Sexe : " + creatureObj.getGender() + "\n" +
        "█ Poids : " + creatureObj.getWeight() + " kg" + "\n" +
        "█ Taille : " + creatureObj.getTall() + " cm" + "\n" +
        "█ Âge : " + creatureObj.getAge() + " an(s)" + "\n" +
        "█ Faim : " + creatureObj.getHungryIndicator() + "%" + "\n" +
        "█ Sommeil : " + creatureObj.getSleepIndicator() + "\n" +
        "█ Santé : " + creatureObj.getHealthIndicator() + "%" + "\n" +
        "█ Mode reproduction : " + "\n" +
        sameCharacter("█", 30));
    }
    if (category == "ACTION") {
      System.out.println(
        sameCharacter("█", 30) + "\n" +
        "█   Zoo" + sameCharacter(" ", 22) + "█" + "\n" +
        "█   Maître" + sameCharacter(" ", 19) + "█" + "\n" +
        "█   Enclos" + sameCharacter(" ", 19) + "█" + "\n" +
        "█   Créature" + sameCharacter(" ", 17) + "█" + "\n" +
        "█ > Action <" + sameCharacter(" ", 17) + "█" + "\n" +
        sameCharacter("█", 30) + "\n" +
        "█-ACTION" + sameCharacter("-", 21) + "█\n" +
        "█ [aj/AJ] Ajouter créature" + sameCharacter(" ", 3) + "█" + "\n" +
        "█ [el/EL] Enlever créature" + sameCharacter(" ", 3) + "█" + "\n" +
        "█ [sg/SG] Soigner créature" + sameCharacter(" ", 3) + "█" + "\n" +
        "█ [nr/NR] Nourrir créatures" + sameCharacter(" ", 2) + "█" + "\n" +
        "█ [tr/TR] Transférer créature" + "█" + "\n" +
        "█ [et/ET] Entretenir enclos" + sameCharacter(" ", 2) + "█" + "\n" +
        sameCharacter("█", 30));
    }
  }
  
  public static String scanKeys(Scanner scannerName) {
    System.out.println("zZ / sS : déplacement menu\n" +
                       "qQ / dD : changement de zoo");
    System.out.println("Entrée clavier : ");
    String r = scannerName.nextLine();  
    return r;
  }
  
  public static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  
  public static void main(String[] args) {

    Creature lyc0 = new Creature("lycanthrope", "mâle", 70, 176, 29, 78, false, 82, "aooooouuuuuh");
    Creature lyc1 = new Creature("lycanthrope", "femelle", 65, 167, 27, 78, false, 82, "aooooouuuuuh");
    Creature lyc2 = new Creature("lycanthrope", "mâle", 67.5, 177, 47, 78, false, 82, "aooooouuuuuh");
    Creature lyc3 = new Creature("lycanthrope", "femelle", 72, 165, 14, 78, false, 82, "aooooouuuuuh");
    Creature lyc4 = new Creature("lycanthrope", "mâle", 75, 173, 17, 78, false, 82, "aooooouuuuuh");
    Creature lyc5 = new Creature("lycanthrope", "femelle", 71.5, 171, 24, 78, false, 82, "aooooouuuuuh");
    Creature lyc6 = new Creature("lycanthrope", "mâle", 79, 166.5, 25, 78, false, 82, "aooooouuuuuh");
    Creature lyc7 = new Creature("lycanthrope", "femelle", 62.5, 166, 18, 78, false, 82, "aooooouuuuuh");
    Creature lyc8 = new Creature("lycanthrope", "mâle", 69, 179, 36, 78, false, 82, "aooooouuuuuh");
    Creature lyc9 = new Creature("lycanthrope", "femelle", 70.5, 177, 49, 78, false, 82, "aooooouuuuuh");
    Creature lyc10 = new Creature("lycanthrope", "mâle", 70, 176, 52, 78, false, 82, "aooooouuuuuh");
    Creature lyc11 = new Creature("lycanthrope", "femelle", 68, 161.5, 44, 78, false, 82, "aooooouuuuuh");
    Creature lyc12 = new Creature("lycanthrope", "mâle", 65, 176.25, 30, 78, false, 82, "aooooouuuuuh");
    Creature lyc13 = new Creature("lycanthrope", "femelle", 61, 160, 19, 78, false, 82, "aooooouuuuuh");
    Creature lyc14 = new Creature("lycanthrope", "mâle", 78.25, 178, 22, 78, false, 82, "aooooouuuuuh");
    Creature lyc15 = new Creature("lycanthrope", "femelle", 69, 164, 17, 78, false, 82, "aooooouuuuuh");
    Creature lyc16 = new Creature("lycanthrope", "mâle", 80, 193, 29, 78, false, 82, "aooooouuuuuh");
    Creature lyc17 = new Creature("lycanthrope", "femelle", 75, 162, 39, 78, false, 82, "aooooouuuuuh");
    Creature lyc18 = new Creature("lycanthrope", "mâle", 63, 166, 27, 78, false, 82, "aooooouuuuuh");
    Creature lyc19 = new Creature("lycanthrope", "femelle", 71, 185, 15, 78, false, 82, "aooooouuuuuh");
    Creature lyc20 = new Creature("lycanthrope", "mâle", 70, 181, 19, 78, false, 82, "aooooouuuuuh");
    Creature lyc21 = new Creature("lycanthrope", "femelle", 57, 162, 34, 78, false, 82, "aooooouuuuuh");
    Creature lyc22 = new Creature("lycanthrope", "mâle", 86, 177, 40, 78, false, 82, "aooooouuuuuh");
    Creature lyc23 = new Creature("lycanthrope", "femelle", 60, 158, 13, 78, false, 82, "aooooouuuuuh");
    Creature lyc24 = new Creature("lycanthrope", "mâle", 63.25, 171, 15, 78, false, 82, "aooooouuuuuh");
    Creature lyc25 = new Creature("lycanthrope", "femelle", 67, 163.25, 39, 78, false, 82, "aooooouuuuuh");
    Creature lyc26 = new Creature("lycanthrope", "mâle", 74.5, 180, 46, 78, false, 82, "aooooouuuuuh");
    Creature lyc27 = new Creature("lycanthrope", "femelle", 74, 174, 27, 78, false, 82, "aooooouuuuuh");
    Creature lyc28 = new Creature("lycanthrope", "mâle", 77, 179, 20, 78, false, 82, "aooooouuuuuh");
    Creature lyc29 = new Creature("lycanthrope", "femelle", 73.25, 172, 23, 78, false, 82, "aooooouuuuuh");
    Creature lyc30 = new Creature("lycanthrope", "mâle", 66, 165, 36, 78, false, 82, "aooooouuuuuh");
    Creature lyc31 = new Creature("lycanthrope", "femelle", 65.5, 164, 17, 78, false, 82, "aooooouuuuuh");
    Creature lyc32 = new Creature("lycanthrope", "mâle", 67.25, 168, 16, 78, false, 82, "aooooouuuuuh");
    Creature lyc33 = new Creature("lycanthrope", "femelle", 71, 169, 18, 78, false, 82, "aooooouuuuuh");
    Creature lyc34 = new Creature("lycanthrope", "mâle", 73, 173.5, 32, 78, false, 82, "aooooouuuuuh");
    Creature lyc35 = new Creature("lycanthrope", "femelle", 74, 172, 28, 78, false, 82, "aooooouuuuuh");
    Creature lyc36 = new Creature("lycanthrope", "mâle", 62, 166, 26, 78, false, 82, "aooooouuuuuh");
    Creature lyc37 = new Creature("lycanthrope", "femelle", 60, 163, 34, 78, false, 82, "aooooouuuuuh");
    Creature lyc38 = new Creature("lycanthrope", "mâle", 79, 176, 26, 78, false, 82, "aooooouuuuuh");
    Creature lyc39 = new Creature("lycanthrope", "femelle", 83, 175, 17, 78, false, 82, "aooooouuuuuh");
    Creature lyc40 = new Creature("lycanthrope", "mâle", 87, 179, 19, 78, false, 82, "aooooouuuuuh");
    Creature lyc41 = new Creature("lycanthrope", "femelle", 64, 168, 24, 78, false, 82, "aooooouuuuuh");
    Creature lyc42 = new Creature("lycanthrope", "mâle", 70.5, 169, 42, 78, false, 82, "aooooouuuuuh");
    Creature lyc43 = new Creature("lycanthrope", "femelle", 72.25, 165, 49, 78, false, 82, "aooooouuuuuh");
    Creature lyc44 = new Creature("lycanthrope", "mâle", 71, 170.25, 32, 78, false, 82, "aooooouuuuuh");
    Creature lyc45 = new Creature("lycanthrope", "femelle", 76, 166, 20, 78, false, 82, "aooooouuuuuh");
    Creature lyc46 = new Creature("lycanthrope", "mâle", 73, 176, 23, 78, false, 82, "aooooouuuuuh");
    Creature lyc47 = new Creature("lycanthrope", "femelle", 71, 176, 14, 78, false, 82, "aooooouuuuuh");
    Creature lyc48 = new Creature("lycanthrope", "mâle", 61, 186, 15, 78, false, 82, "aooooouuuuuh");
    Creature lyc49 = new Creature("lycanthrope", "femelle", 67.25, 166, 19, 78, false, 82, "aooooouuuuuh");
    Creature lyc50 = new Creature("lycanthrope", "mâle", 60.5, 155, 13, 78, false, 82, "aooooouuuuuh");
    Creature lyc51 = new Creature("lycanthrope", "femelle", 73.5, 176, 29, 78, false, 82, "aooooouuuuuh");
    Creature lyc52 = new Creature("lycanthrope", "mâle", 80, 187, 21, 78, false, 82, "aooooouuuuuh");
    Creature lyc53 = new Creature("lycanthrope", "femelle", 82, 173, 24, 78, false, 82, "aooooouuuuuh");
    Creature lyc54 = new Creature("lycanthrope", "mâle", 79, 186, 22, 78, false, 82, "aooooouuuuuh");
    Creature lyc55 = new Creature("lycanthrope", "femelle", 85, 174, 30, 78, false, 82, "aooooouuuuuh");
    Creature lyc56 = new Creature("lycanthrope", "mâle", 86, 196, 27, 78, false, 82, "aooooouuuuuh");
    Creature lyc57 = new Creature("lycanthrope", "femelle", 68, 153, 19, 78, false, 82, "aooooouuuuuh");
    Creature lyc58 = new Creature("lycanthrope", "mâle", 71.25, 186, 27, 78, false, 82, "aooooouuuuuh");
    Creature lyc59 = new Creature("lycanthrope", "femelle", 77, 172, 16, 78, false, 82, "aooooouuuuuh");
    Creature lyc60 = new Creature("lycanthrope", "mâle", 78, 178, 19, 78, false, 82, "aooooouuuuuh");
    Creature lyc61 = new Creature("lycanthrope", "femelle", 72, 166, 29, 78, false, 82, "aooooouuuuuh");

    Creature krak0 = new Creature("kraken", "femelle", 53000, 1300, 131, 30, false, 70, "WOOOOOOOOOOOOOOON");
    Creature krak1 = new Creature("kraken", "mâle", 57000, 1200, 164, 30, false, 70, "WOOOOOOOOOOOOOOON");
    Creature krak2 = new Creature("kraken", "mâle", 56000, 1400, 152, 30, false, 70, "WOOOOOOOOOOOOOOON");

    Creature sir0 = new Creature("sirène", "femelle", 60, 160, 21, 80, false, 100, "ooh");
    Creature sir1 = new Creature("sirène", "femelle", 67, 170, 17, 80, false, 100, "ooh");
    Creature sir2 = new Creature("sirène", "femelle", 62, 168, 15, 80, false, 100, "ooh");
    Creature sir3 = new Creature("sirène", "femelle", 59, 161, 19, 80, false, 100, "ooh");
    Creature sir4 = new Creature("sirène", "femelle", 64, 154, 18, 80, false, 100, "ooh");
    Creature sir5 = new Creature("sirène", "femelle", 67.5, 172, 22, 80, false, 100, "ooh");
    Creature sir6 = new Creature("sirène", "femelle", 61, 166, 20, 80, false, 100, "ooh");
    Creature sir7 = new Creature("sirène", "femelle", 58, 165, 25, 80, false, 100, "ooh");
    Creature sir8 = new Creature("sirène", "femelle", 69, 167, 27, 80, false, 100, "ooh");
    Creature sir9 = new Creature("sirène", "femelle", 72, 162, 20, 80, false, 100, "ooh");
    Creature sir10 = new Creature("sirène", "femelle", 61.25, 161, 23, 80, false, 100, "ooh");

    Creature phen0 = new Creature("phénix", "femelle", 7, 40, 2, 100, true, 100, "craaaah");
    Creature phen1 = new Creature("phénix", "mâle", 9, 50, 1, 100, true, 100, "craaaah");
    Creature phen2 = new Creature("phénix", "femelle", 8, 45, 3, 100, true, 100, "craaaah");
    Creature phen3 = new Creature("phénix", "mâle", 10, 57, 5, 100, true, 100, "craaaah");
    Creature phen4 = new Creature("phénix", "femelle", 8.5, 55, 3, 100, true, 100, "craaaah");

    Creature drag0 = new Creature("dragon", "mâle", 5100, 1700, 48, 40, false, 100, "raaaaaaah");
    Creature drag1 = new Creature("dragon", "femelle", 5050, 1600, 48, 40, false, 100, "raaaaaaah");
    Creature drag2 = new Creature("dragon", "mâle", 5300, 1810, 48, 40, false, 100, "raaaaaaah");
    Creature drag3 = new Creature("dragon", "femelle", 5430, 1720, 48, 40, false, 100, "raaaaaaah");
    Creature drag4 = new Creature("dragon", "mâle", 5170, 1900, 48, 40, false, 100, "raaaaaaah");
    Creature drag5 = new Creature("dragon", "femelle", 4980, 1560, 48, 40, false, 100, "raaaaaaah");
    Creature drag6 = new Creature("dragon", "mâle", 5090, 1760, 48, 40, false, 100, "raaaaaaah");
    Creature drag7 = new Creature("dragon", "femelle", 4790, 1560, 48, 40, false, 100, "raaaaaaah");
    Creature drag8 = new Creature("dragon", "mâle", 5600, 1680, 48, 40, false, 100, "raaaaaaah");
    Creature drag9 = new Creature("dragon", "femelle", 5200, 1590, 48, 40, false, 100, "raaaaaaah");
    Creature drag10 = new Creature("dragon", "mâle", 5400, 1520, 48, 40, false, 100, "raaaaaaah");
    Creature drag11 = new Creature("dragon", "femelle", 5100, 1750, 48, 40, false, 100, "raaaaaaah");
    Creature drag12 = new Creature("dragon", "mâle", 5800, 1660, 48, 40, false, 100, "raaaaaaah");
    Creature drag13 = new Creature("dragon", "femelle", 5300, 1580, 48, 40, false, 100, "raaaaaaah");

    Creature meg0 = new Creature("mégalodon", "mâle", 41500, 1700, 15, 20, false, 90, "ROOOOOOH");
    Creature meg1 = new Creature("mégalodon", "femelle", 43700, 1400, 15, 20, false, 90, "ROOOOOOH");
    Creature meg2 = new Creature("mégalodon", "mâle", 41300, 1600, 15, 20, false, 90, "ROOOOOOH");
    Creature meg3 = new Creature("mégalodon", "femelle", 41200, 1300, 15, 20, false, 90, "ROOOOOOH");

    Creature nym0 = new Creature("nymphe", "femelle", 47, 157, 17, 85, false, 100, "heeey");
    Creature nym1 = new Creature("nymphe", "femelle", 48.5, 160, 17, 85, false, 100, "heeey");
    Creature nym2 = new Creature("nymphe", "femelle", 52, 161, 17, 85, false, 100, "heeey");
    Creature nym3 = new Creature("nymphe", "femelle", 55, 154, 17, 85, false, 100, "heeey");
    Creature nym4 = new Creature("nymphe", "femelle", 46.25, 150, 17, 85, false, 100, "heeey");
    Creature nym5 = new Creature("nymphe", "femelle", 45, 155, 17, 85, false, 100, "heeey");
    Creature nym6 = new Creature("nymphe", "femelle", 51, 162, 17, 85, false, 100, "heeey");
    Creature nym7 = new Creature("nymphe", "femelle", 48.5, 157, 17, 85, false, 100, "heeey");
    Creature nym8 = new Creature("nymphe", "femelle", 49, 159, 17, 85, false, 100, "heeey");
    Creature nym9 = new Creature("nymphe", "femelle", 53, 153, 17, 85, false, 100, "heeey");
    Creature nym10 = new Creature("nymphe", "femelle", 57, 162, 17, 85, false, 100, "heeey");
    Creature nym11 = new Creature("nymphe", "femelle", 50.5, 153.7, 17, 85, false, 100, "heeey");
    Creature nym12 = new Creature("nymphe", "femelle", 44, 155, 17, 85, false, 100, "heeey");
    Creature nym13 = new Creature("nymphe", "femelle", 47.5, 161.5, 17, 85, false, 100, "heeey");
    Creature nym14 = new Creature("nymphe", "femelle", 51.25, 163, 17, 85, false, 100, "heeey");

    Creature lico0 = new Creature("licorne", "femelle", 470, 157, 17, 100, false, 90, "ihihihih");
    Creature lico1 = new Creature("licorne", "femelle", 490, 138, 22, 100, false, 90, "ihihihih");
    Creature lico2 = new Creature("licorne", "femelle", 485, 162, 12, 100, false, 90, "ihihihih");
    Creature lico3 = new Creature("licorne", "femelle", 430, 154, 15, 100, false, 90, "ihihihih");
    Creature lico4 = new Creature("licorne", "femelle", 478, 132, 11, 100, false, 90, "ihihihih");
    Creature lico5 = new Creature("licorne", "femelle", 442, 156, 14, 100, false, 90, "ihihihih");
    
    Enclosure enclos0_0 = new Enclosure("Enclos de lycanthropes 0", 700, 30, Arrays.asList(lyc0, lyc1, lyc2, lyc3, lyc4, lyc5, lyc6), "correct");
    Enclosure enclos0_1 = new Enclosure("Enclos de krakens", 2000, 5, Arrays.asList(krak0, krak1, krak2), "correct");
    Enclosure enclos0_2 = new Enclosure("Enclos de sirènes", 500, 60, Arrays.asList(sir0, sir1, sir2, sir3, sir4, sir5), "bon");
    Enclosure enclos0_3 = new Enclosure("Enclos de phénix", 80, 25, Arrays.asList(phen0, phen1, phen2, phen3, phen4), "bon");
    Enclosure enclos0_4 = new Enclosure("Enclos de lycanthropes 1", 800, 45, Arrays.asList(lyc7, lyc8, lyc9, lyc10, lyc11, lyc12, lyc13, lyc14, lyc15), "mauvais");
    Enclosure enclos0_5 = new Enclosure("Enclos de dragons", 3000, 12, Arrays.asList(drag0, drag1, drag2, drag3, drag4, drag5), "correct");
    Enclosure enclos1_0 = new Enclosure("Enclos de mégalodons", 4000, 6, Arrays.asList(meg0, meg1, meg2, meg3), "mauvais");
    Enclosure enclos1_1 = new Enclosure("Enclos de lycanthropes 0", 600, 36, Arrays.asList(lyc16, lyc17, lyc18, lyc19, lyc20, lyc21, lyc22, lyc23, lyc24, lyc25), "mauvais");
    Enclosure enclos1_2 = new Enclosure("Enclos de lycanthropes 1", 1000, 47, Arrays.asList(lyc26, lyc27, lyc28, lyc29, lyc30, lyc31, lyc32), "correct");
    Enclosure enclos1_3 = new Enclosure("Enclos de dragons", 4500, 15, Arrays.asList(drag6, drag7, drag8, drag9, drag10, drag11, drag12, drag13), "correct");
    Enclosure enclos2_0 = new Enclosure("Enclos de nymphes", 180, 27, Arrays.asList(nym0, nym1, nym2, nym3, nym4, nym5), "bon");
    Enclosure enclos2_1 = new Enclosure("Enclos de sirènes", 260, 60, Arrays.asList(sir6, sir7, sir8, sir9, sir10), "bon");
    Enclosure enclos2_2 = new Enclosure("Enclos de lycanthropes 0", 1600, 26, Arrays.asList(lyc33, lyc34, lyc35, lyc36, lyc37, lyc38, lyc39, lyc40, lyc41, lyc42, lyc43, lyc44), "correct");
    Enclosure enclos2_3 = new Enclosure("Enclos de nymphes", 240, 37, Arrays.asList(nym6, nym7, nym8, nym9, nym10, nym11, nym12, nym13, nym14), "bon");
    Enclosure enclos2_4 = new Enclosure("Enclos de lycanthropes 1", 900, 51, Arrays.asList(lyc45, lyc46, lyc47, lyc48, lyc49, lyc50, lyc51, lyc52, lyc53, lyc54), "mauvais");
    Enclosure enclos2_5 = new Enclosure("Enclos de lycanthropes 2", 700, 34, Arrays.asList(lyc55, lyc56, lyc57, lyc58, lyc59, lyc60, lyc61), "bon");
    Enclosure enclos2_6 = new Enclosure("Enclos de licornes", 130, 42, Arrays.asList(lico0, lico1, lico2, lico3, lico4, lico5), "bon");
    
    Master maitreA = new Master("Hommaître0", "homme", 35);
    Master maitreB = new Master("Femmaître", "femme", 22);
    Master maitreC = new Master("Hommaître1", "homme", 40);
    
    FantasticZoo zoo0 = new FantasticZoo("Zoo n°0", maitreA, 8, Arrays.asList(enclos0_0, enclos0_1, enclos0_2, enclos0_3, enclos0_4, enclos0_5));
    FantasticZoo zoo1 = new FantasticZoo("Zoo n°1", maitreB, 5, Arrays.asList(enclos1_0, enclos1_1, enclos1_2, enclos1_3));
    FantasticZoo zoo2 = new FantasticZoo("Zoo n°2", maitreC, 7, Arrays.asList(enclos2_0, enclos2_1, enclos2_2, enclos2_3, enclos2_4, enclos2_5, enclos2_6));
    
    List<String> categ = new ArrayList<>();
    categ.add("ZOO");
    categ.add("MAÎTRE");
    categ.add("ENCLOS");
    categ.add("CRÉATURE");
    categ.add("ACTION");
    int categIndex = 0;

    List<FantasticZoo> zoos = new ArrayList<>();
    zoos.add(zoo0);
    zoos.add(zoo1);
    zoos.add(zoo2);
    int zoosIndex = 0;

    int enclosIndex = 0;
    int creatIndex = 0;
    
    clearConsole();
    displayZoo(zoos.get(zoosIndex));
    displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
    Scanner sc = new Scanner(System.in);
    String mainInput = scanKeys(sc);

    boolean loop = true;

    while (loop == true) {
      mainInput = scanKeys(sc);
      
      if (mainInput.equals("z") || mainInput.equals("Z")) {
        --categIndex;
        if (categIndex < 0) {
          categIndex = categ.size() - 1;
        }
        clearConsole();
        displayZoo(zoos.get(zoosIndex));
        displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
      }

      if (mainInput.equals("q") || mainInput.equals("Q")) {
        if (categ.get(categIndex) == "ZOO" || categ.get(categIndex) == "MAÎTRE") {
          --zoosIndex;
          if (zoosIndex < 0) {
            zoosIndex = zoos.size() - 1;
          }
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
        else if (categ.get(categIndex) == "ENCLOS") {
          --enclosIndex;
          if (enclosIndex < 0) {
            enclosIndex = zoos.get(zoosIndex).getEnclosures().size() - 1;
          }
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
        else if (categ.get(categIndex) == "CRÉATURE") {
          --creatIndex;
          if (creatIndex < 0) {
            creatIndex = zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().size() - 1;
          }
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
        else {
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
      }

      if (mainInput.equals("s") || mainInput.equals("S")) {
        ++categIndex;
        if (categIndex == categ.size()) {
          categIndex = 0;
        }
        clearConsole();
        displayZoo(zoos.get(zoosIndex));
        displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
      }

      if (mainInput.equals("d") || mainInput.equals("D")) {
        if (categ.get(categIndex) == "ZOO" || categ.get(categIndex) == "MAÎTRE") {
          ++zoosIndex;
          if (zoosIndex == zoos.size()) {
            zoosIndex = 0;
          }
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
        else if (categ.get(categIndex) == "ENCLOS") {
          ++enclosIndex;
          if (enclosIndex == zoos.get(zoosIndex).getEnclosures().size()) {
            enclosIndex = 0;
          }
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
        else if (categ.get(categIndex) == "CRÉATURE") {
          ++creatIndex;
          if (creatIndex == zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().size()) {
            creatIndex = 0;
          }
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
        else {
          clearConsole();
          displayZoo(zoos.get(zoosIndex));
          displayCharacteristics(zoos.get(zoosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex), zoos.get(zoosIndex).getEnclosures().get(enclosIndex).getCreatures().get(creatIndex), categ.get(categIndex));
        }
      }
    }

    sc.close();
  }
}