/**
 *	Класс, реализующий интерфейс IPerson, содержащий в себе поля id, имя,
 *	фамилию, дату рождения, пол, размер З/П и подразделение
 * @Author MrBletskowitz
 * @Version 0.1
 */
package myPackage;

import org.joda.time.DateTime;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement
@XmlType(propOrder = {"firstName", "lastName", "gender", "salary", "division"})
public class Person implements IPerson {

	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Gender gender;
	private BigDecimal salary;
	private IDivision division;

	/**
	 * Конструктор класса Person
	 * @param id - id
	 * @param firstName - имя
	 * @param lastName - фамилия
	 * @param birthday - дата рождения
	 * @param gender - пол
	 * @param salary - размер З/П
	 * @param division - подразделение
	 */
	public Person(int id, String firstName, String lastName, LocalDate birthday, Gender gender, BigDecimal salary, IDivision division) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.salary = salary;
		Division div = new Division();
		//this.division = div.check(division.getName());
	}

	/**
	 * Конструктор по-умолчанию
	 */
	public Person(){

	}


	/**
	 * Получение Id
	 * @return id человека
	 */
	@XmlAttribute
	public Integer getId() {
		return id;
	}

	@XmlTransient
	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/**
	 * Задание Id
	 * @param id - новый id
	 */
	public void setId(Integer id){
		this.id = id;
	}

	/**
	 * Получение имени
	 * @return имя
	 */
	public String getFirstName(){
		return this.firstName;
	}

	/**
	 * задание имени
	 * @param firstName - новое имя
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	/**
	 * Получение фамилии
	 * @return фамилия
	 */
	public String getLastName(){
		return this.lastName;
	}

	/**
	 * Задание фамилии
	 * @param lastName - новая фамилия
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	/**
	 * Получение даты рождения
	 * @return дата рождения
	 */
	@XmlTransient
	public LocalDate getBirthdate(){
		return this.birthday;
	}

	/**
	 * Установление даты рожджения
	 * @param birthdate - новая дата рождения
	 */
	public void setBirthdate(LocalDate birthdate){
		this.birthday = birthdate;
	};

	/**
	 * Get a gender of person
	 * @return gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Get person's age using birthdate
	 * @return age
	 */
	public Integer getAge() {
		//DateTime today = new DateTime();
		//today = DateTime.now();
		//if(today.getMonthOfYear() > birthday.getMonthOfYear())
		//	return (today.getYear() - birthday.getYear());
		//else return (today.getYear() - birthday.getYear() - 1);

		LocalDate today = LocalDate.now();
		if(today.getMonthValue() > birthday.getMonthValue()){
			return (today.getYear() - birthday.getYear());
		}
		else{
			return (today.getYear() - birthday.getYear() - 1);
		}
	}

	/**
	 * Get person's salary
	 * @return salary
	 */
	public BigDecimal getSalary(){
		return this.salary;
	}

	/**
	 * Set person's salary
	 * @param salary - new salary
	 */
	public void setSalary(BigDecimal salary){
		this.salary = salary;
	}

	/**
	 * set person's gender
	 * @param gender - new gender
	 */
	public void setGender(Gender gender){
		this.gender = gender;
	}

	/**
	 * Get person's division
	 * @return division
	 */
	@XmlAnyElement
	public IDivision getDivision(){
		return this.division;
	}

	/**
	 * Set person's divisoon
	 * @param division - new division
	 */
	public void setDivision(IDivision division){
		Division div = new Division();
		this.division = div.check(division.getName());
	}

}
