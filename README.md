Life Management System

Opis projekta

Life Management System je aplikacija razvijena u JavaFX i Swing-u, 
koja omogućava korisnicima da prate svoje dnevne aktivnosti, raspoloženje, 
navike, plan učenja, san i finansije. Projekat je povezan sa MongoDB bazom 
koja pohranjuje sve podatke po korisniku. Finance modul je implementiran kao 
zaseban Swing prozor i omogućava praćenje prihoda, rashoda i kategorija 
troškova.

Funkcionalnosti

Pokretanjem aplikacije otvara se početni prozor za registraciju ili login (zavisi
da li već imamo account ili nemamo) te nakon toga idemo na main menu gdje imamo
četiri trackera koje možemo da pratimo:Finance Tracker,Habit Tracker,Sleep Tracker,
Study Planner i Mood Tracker.Aplikacija funkcioniše tako da kada unesemo svoju
aktivnost i kliknemo dugme "Save" podaci se spremaju u bazu podataka te klikom
na dugme "Show stats" prikazuju nam se statistički podaci tipa average sleep.

Tehnologije

Projekat je rađen u razvojnom okruženju InteliJ IDEA gdje je razvijena JavaFX
aplikacija uz ugrađivanje projekta Finance Tracker koji je rađen kao Java 
Swing aplikacija.Za bazu podataka korišten je MongoDB server i za prvi dio 
(Finance Tracker) kao i za ostale trackere.