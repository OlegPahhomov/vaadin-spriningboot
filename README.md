# vaadin-spriningboot

Certified personnel app with vaadin-springboot.

Open in favorite IDE and run Application.java main method.
Or mvn clean install spring-boot:run


I have some issues and things to do:
* I am confused how to organize Vaadin classes, they tend to get big fast. Brings back memories of jsf 1.0.
* I have noted exam score as String, should be number, but I've found it's difficult/tricky with Viritin/Vaadin to set it to number.
It's not default behaviour of Viritin and setting bean properties seems to be far under the surface.
* My architectural model is far from perfect, usually in this case neither people nor exams should be insertable, but enumised/fixed, coming from database etc
I went with what I had designed and changing it all takes time.
* Validation is weird on examCode bit.

Positive experiences:
* I am positively surprised how much one could do with very limited time.
* It is nice I didn't have to focus on design (time-saver)