
POLYNOM
המחלקה POLYNOM משתמשת ב AraayList<Monom> בשם POL
public Polynom()
build the Polynom with adding only the zero monom to the arraylist
public Polynom(String s)
הפונקציה מקבלת מחרוזת המבאטת פולינום. ויוצרת ArrayList   של מונומים.
הפונקציה בעזרת פונקציית SPLIT(הפונקציה מחלקת לפי התווים "+"  "-")  מחלקת את המחרוזת לרשימה  של מחרוזות של מונומים . ומוסיפה כל מונום לarrayLIst  POL בצורת 
טיפוס MONOM.
  בעזרת השיטה.
 public Monom(String s)
קלט יהיה תקין עבור פולינום בלבד. בלי תווים אחרים כגון סוגרים  מרכאות וכו'....


public String toString()
הפונקציה עוברת על כל איבר(מונום) בפולינום  ומחזירה  מחרוזת של הפולינום המורכבת משרשור מחרוזות המונומים.


public void multiply(Monom m1)
הפונק תכפיל את הפולינום במונום שהיא מקבלת. 
הפונקציה תשנה את המקדם  ואת החזקה של כל מונום בפולינום.  (חיבור חזקות והכפלת מקדמים).


	public double area(double x0, double x1, double eps) הפונקציה מחזירה את שטח בין איקס אפס לאיקס אחד .
הפונק מקבלת שני Xים  ו EPS (אפסילון) מבצעת בדיקת קלט 
if(x0 > x1 || eps<=0 || eps>(x1-x0))  זרוק שגיאה.
רצה בלולאה FOR  from ,x0 to x1  בקפיצות  של אפלסילון ומחברת את סכום המלבנים (גובה FX כפול אפסילון.)



public double f(double x) 
return the value of the polynom for a given x
for each monom in the polynim it use the the f function of monom sum them all.

public void add(Polynom_able p1) 
 add all the p1 monoms to this pol and send it to arrange()

public void arrange()
going on pol and if there are two monoms with the same value its united them and remove one of them.

public void add(Monom m1) 

going on pol and check if one of it monoms can be added to m1
if it does so it add it wuth monom.add 
else it add m1 to the and of the list(pol)

public void substract(Polynom_able p1) {

multiply each monom at p1 by (-1) and then use the add punction to add it to the pol 

public void multiply(Polynom_able p1) 

using they iterators, multiplies each monom at this with each monom at p1 with the monom multiply function .

public boolean equals(Polynom_able p1) 
using they iterators each iteration check if the monom in this polynom at the same place of the monom in p1 are equals.
If not return false
Else after checking all of them return true

public boolean isZero() 
using iterator checks if one of the polynom's monom's coefficient is not zero then return false, else return true.

public double root(double x0, double x1, double eps) 
this function is recursive.
Return error if:
f(x1)*f(x0) > 0 || x1<=x0 || eps <= 0

with given x0,x1 and m=x0+x1/2 it checks if the f(m)<eps
if it does it return m.
if it doesn’t so it checks* if x0 or x1 should be replased with m to the next recursive call.

*The check is testing if the m is with the same sign(+/-)
of x0 or x1 and then go with the one that have the opposite sign.


public Polynom_able copy() 
deep copy.
create new polynom and using this.iterator and build a new monoms from this monoms and add it to the new polynom.


public Polynom_able derivative() 
returns a new polynom_able that made of this monoms.derivative function.



 











 
class monom

public Monom(String s)
הפונקציה מקבל מחזורת (STRING) של מונום  ומחזירה  טיפוס מונום שכולל 
A-המקדם של X ,  ו B- החזקה של X.  המחרוזת שהפונ' מקבלת חייבת להיות או
1)	מונום הכולל מקדם ,x  , קטן בלבד (לא X גדול) , והחזקה.
2)	מספר ממשי 
3)	X,  -X
בלבד.(קלט אחר יזרוק הודעת שגיאה)
הפונקציה תבדוק את הקלט אם הוא שווה למספר היא תשמש בפונקציה ISNNUMERIC להמיר אותו לDOUBLE   ותחזיר את A.B  
ובמקרה  של קלט מסוג   AX^B היא  תקרא לפונ עזר  SumPower Sumcoefficient
 להחזיר את הערכים הרצויים.




public  double Sumcoefficient(String s)
הפונק מקבלת מחרוזת המבטאת מונום  ומחזירה את המקדם של המונום.
הופנקציה עובר על המחרוזת תו אחרי תו עד שהיא מזהה את X  ומזירה ערך DOUBLE  של המקדם.


public  int Sumpower(String s)
הפונק מקבל מחזורת המבטאת מספר שהוא החזקה של המונום. במקרה של קלט שהוא לא מספר שלם היא תזרוק שגיאה . הפונקציה תחזיר את הער החזקה בINT



 



public void add(Monom m)
this method gets a parameter of type Monom and add it to this Monom while check if it can be done aritmaticaly it adding the coefficient.if the two powers aren’t the same it throws exeption.
public void multipy(Monom d) 
this method multiplies two monoms seting this monom with
multiply the coefficients and adding the powers.
public String toString() 
returns a string represent the Monom.

public boolean equals(Monom m) 
check if the monoms are logicly equals(have the same coefficient and power)

All the other methods in class Monom were given by the teacher. *

