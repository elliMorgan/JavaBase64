CC=javac
TARGET=mainacv01
SRCS=CLI.java mainacv01.java B64Encoding.java

all: clean $(TARGET).class


$(TARGET).class: $(SRCS)
	$(CC) $(SRCS)
# 	$(CC) $<


clean:
	-rm *.class
# 	-rm $(TARGET).aux
# 	-rm $(TARGET).log
# 	-rm $(TARGET).pdf
# 	-rm $(TARGET).toc
# 	-rm $(TARGET).out
