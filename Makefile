test: MarkdownParse.java
	javac MarkdownParse.java
	echo "hello"

test2: 
	echo "hi"

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

