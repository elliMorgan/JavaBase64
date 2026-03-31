CC=pdflatex
DOC=report


all: clean $(DOC).pdf


$(DOC).pdf: $(DOC).tex
	$(CC) $<
	$(CC) $<


clean:
	-rm $(DOC).aux
	-rm $(DOC).log
	-rm $(DOC).pdf
	-rm $(DOC).toc
	-rm $(DOC).out
