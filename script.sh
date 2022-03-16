
for file in markdown-parse-main/test-files/*.md;
do
  echo "$file"
  java MarkdownParse2 $file
done
