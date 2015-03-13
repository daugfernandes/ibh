# Indent-based hierarchy #

A parser for a simple human readable hierarchical structure. Something like Xml or Json but intended for simplified human use.

The format is quite simple and based on indentation; the number of leading white spaces.

**Note:**
The use of TAB chars along with WHITE spaces may cause incorrect and unexpected results.

Please refer to the javadoc on how to automatically convert TABS to a given number of WHITE spaces in order to overcome this issue. However, the best advice is not to use TAB.

**Example:**

```
book
   name = xml for dummyes
   number of pages = 999
   table of contents
      chapter 1
         title = wow this stuff is good
      chapter 2
         title = another amazing good stuff
      chapter 3
         title = missing
   author = very clever
       name = john smith
       affiliation = uau
```

**Expected behaviour:**

```
book.name -> xml for dummyes
book.table of contents.chapter 1.title -> wow this stuff is good
book.table of contents -> null
book.author.birthdate -> null
book.author -> very clever
```

**Usage:**

```
se7ening.files.Ibh configIbh = new se7ening.files.Ibh();1
boolean configOk = configIbh.parseFile("/usr/app/config1.ibh");

if(configOk) {
	// get a specific value
	String  result = configIbh.getNode("book.author").getValue();
	
	// iterate
	Node tableOfContents = configIbh.getNode("book.table of contents");
	for (Node chapterNode : tableOfContents.getNodes()) {
		String chapterTitle = chapterNode.getNode("title").getValue();
}
```



[javadoc](http://se7ening.dyndns-free.com/ibh/javadoc/)



