java -classpath ../../fudannlp.jar;;../../lib/*; org.fulp.nlp.tag.Tagger -train template train.txt model
java -classpath ../../fudannlp.jar;../../lib/*; org.fulp.nlp.tag.Tagger model test.txt result.txt
@echo delete model file
del model
@echo press any key to delete result.txt file
pause>nul
del result.txt