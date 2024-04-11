/**
 * Exemple sur l'API Date
 */
package cours_exercices.cours;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

// Import


/**
 * Classe principale
 */
public class API_Date {
	// Methode principale
	public static void main(String[] args) {
		// LocalDate
		// Creation d'une date (YYYY-MM-DD)
		LocalDate ld = LocalDate.of(2024,  3, 1);
		System.out.println("Date définie : " + ld);
		
		// Creation d'une date (YYYY-MM-DD) a partir d'une string
		// attention a bien respecter le format sur deux chiffres pour mois et jour.
		ld = LocalDate.parse("2024-02-26");
		System.out.println("Date définie avec string : " + ld);
		
		// Creation d'une date d'aujourd'hui
		ld = LocalDate.now();
		System.out.println("Date d'aujourd'hui : " + ld);
		
		// annee d'une date
		int annee = ld.getYear();
		System.out.println("Année : " + annee);

		// mois d'une date
		Month mois = ld.getMonth();
		System.out.println("Mois : " + mois);
		
		// jour en nombre d'une date
		int jourNb = ld.getDayOfMonth();
		System.out.println("Le jour du mois : " + jourNb);
		
		// jour en lettre d'une date
		DayOfWeek jourSemaine = ld.getDayOfWeek();
		System.out.println("Le jour de la semaine : " + jourSemaine);
		
		// nombre de jours dans le mois
		int nbJours = ld.lengthOfMonth();
		System.out.println("Nombre de jours dans le mois : " + nbJours);
		
		// annee bisextile ou pas ?
		boolean bisextile = ld.isLeapYear();
		System.out.println("Année bisextile ? : " + bisextile);
		
		// il est possible d'obtenir des infos sur date et heures avec l'enumeration ChronoField
		int a = ld.get(ChronoField.YEAR);
		int m = ld.get(ChronoField.MONTH_OF_YEAR);
		int j = ld.get(ChronoField.DAY_OF_MONTH);
		System.out.println("Date : " + j + "/" + m + "/" + a);
		System.out.println();
		
		// LocalTime
		// definition d'une heure (HH:MM:SS)
		LocalTime lt = LocalTime.of(13,  20, 20);
		System.out.println("Heure définie : " + lt);
		
		// Creation d'une date (HH:MM:SS) a partir d'une string
		// attention a bien respecter le format sur deux chiffres.
		lt = LocalTime.parse("13:45:26");
		System.out.println("Heure à partir d'une string : " + lt);
		
		// heure actuelle
		lt = LocalTime.now();
		System.out.println("Heure actuelle : " + lt);
		
		// Obtenir les heures, minutes et seconde de l'heure
		int heure = lt.getHour();
		int minute = lt.getMinute();
		int seconde = lt.getSecond();
		System.out.println("Heure actuelle : " + heure + "h" + minute + "m" + seconde + "s");
		System.out.println();
		
		// LocalDateTime
		// definition d'une date et d'une heure
		LocalDateTime ldt = LocalDateTime.of(2024, Month.DECEMBER, 18, 13, 45, 20);
		System.out.println("Date et heure définies : " + ldt);
		
		// a partir d'une date et une heure deja definie via LocalDate et LocalTime
		ldt = LocalDateTime.of(ld, lt);
		System.out.println("A partir d'une date et une heure deja definie via LocalDate et LocalTime : " + ldt);
		
		// ou en utilisant atTime() sur une variable LocalDate
		ldt = ld.atTime(lt);
		System.out.println("HEure en partant de la date : " + ldt);
		
		// ou en utilisant atDate() sur une variable LocalTime
		ldt = lt.atDate(ld);
		System.out.println("Date en partant de l'heure : " + ldt);
		
		// a partir d'une date deja definie via LocalDate et une heure manuellement
		ldt = ld.atTime(11, 45, 25);
		System.out.println("Date et heure à partir d'une date et d'un heure déjà définies : " + ldt);
		
		// recuperer la date d'un LocalDateTime
		System.out.println("Date du LocalDateTime" + ldt.toLocalDate());
		
		// recuperer l'heure d'un LocalDateTime
		System.out.println("Heure du LocalDateTime" + ldt.toLocalTime());
		
		// Durees entre LocalTime, LocalDateTime ou Instant
		Duration d1 = Duration.between(lt,  ldt.toLocalTime());
		
		// definition d'une duree
		d1 = Duration.ofMinutes(3);
		System.out.println("Définition d'une heure : " + d1);
		
		// ou avec ChronoUnit
		d1 = Duration.of(3, ChronoUnit.MINUTES);
		System.out.println("Définition d'une heure avec ChronoUnit : " + d1.getSeconds());
		
		// Duree sur les dates
		// periode en le 01/01/2024 et aujourd'hui
		Period p = Period.between(LocalDate.of(2024,  01,  01), ld);
		System.out.println("Période entre deux dates en jours : " + p);
	}
}
