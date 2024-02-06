package com.eyupyilmaz.kotlinsearchviewwithrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView : SearchView
    private var languageList = ArrayList<LanguageItem>()
    private lateinit var adapter: LanguageAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.mainRV)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = LanguageAdapter(languageList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        adapter.onItemClick = {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("languageItem",it)
            startActivity(intent)

        }
    }

    private fun filterList(query : String?)
    {
        if (query != null)
        {
            val filteredList = ArrayList<LanguageItem>()
            for (i in languageList)
            {
                if (i.title.lowercase(Locale.ROOT).contains(query))
                {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty())
            {
                Toast.makeText(this, "No Data Found!!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList()
    {
        languageList.add(LanguageItem("C" , R.drawable.c,"C is probably the oldest and popular programming language and is the root of other programming languages such as C#, Java, and JavaScript. C++ is an enhanced version of C. Many developers today skip learning C on its own, while others think learning C first provides a valuable foundation for C++ development. Both languages are widely used in computer science and programming. "))
        languageList.add(LanguageItem("C#"  ,R.drawable.c_sharp,"Developed by Microsoft, C# rose to fame in the 2000s for supporting the concepts of object-oriented programming. It is one of the most used programming languages for the .NET framework. Anders Hejlsberg, the creator of C#, says the language is more like C++ than Java.\n" + "\n"))
        languageList.add(LanguageItem("CSS" , R.drawable.css,"CSS (Cascading Style Sheets) is a style sheet language used to describe how a page that was produced in a markup language is presented. A style sheet, which is a set of rules for web browsers, can control an HTML or XML.\n" +
                "\n" +
                "All HTML tags, including the text in the document's body, headings, paragraphs, and other text elements, are styled using CSS. The display of grid components, table elements, and picture "))
        languageList.add(LanguageItem("HTML" , R.drawable.html,"HTML(HyperText Markup Language) is the standard language for creating web pages and applications. HTML is used to create web pages. You can use HTML to add images, links, and other types of content to your web page. HTML is a simple programming language; you don't need to know much about it to create a basic web page."))
        languageList.add(LanguageItem("JAVA" , R.drawable.java,"Owned by Oracle Corporation, this general-purpose programming language with its object-oriented structure has become a standard for applications that can be used regardless of platform (e.g., Mac, Windows, Android, iOS, etc.) because of its Write Once, Run Anywhere (WORA) capabilities. As a result, Java is recognized for its portability across platforms, from mainframe data centers to smartphones. Today there are more than 3 billion devices running applications built with Java."))
        languageList.add(LanguageItem("JAVA SCRIPT" , R.drawable.js_logo,"JavaScript is a high-level programming language that is one of the core technologies of the World Wide Web. It is used as a client-side programming language by 97.8 percent of all websites. JavaScript was originally used only to develop web browsers, but they are now used for server-side website deployments and non-web browser applications as well. "))
        languageList.add(LanguageItem("PHP" , R.drawable.php,"PHP is an open-source programming language created in 1990. Many web developers find it essential to learn PHP, as this language is used to build more than 80% of websites on the Internet, including notable sites like Facebook and Yahoo."))
        languageList.add(LanguageItem("PYTHON" , R.drawable.python,"Python is one of the most popular programming languages today and is easy for beginners to learn because of its readability. It is a free, open-source programming language with extensive support modules and community development, easy integration with web services, user-friendly data structures, and GUI-based desktop applications. It is a popular programming language for machine learning and deep learning applications. "))
        languageList.add(LanguageItem("KOTLIN" , R.drawable.kotlin,"Kotlin is a general-purpose programming language originally developed and unveiled as Project Kotlin by JetBrains in 2011. The first version was officially released in 2016. It is interoperable with Java and supports functional programming languages."))
        languageList.add(LanguageItem("RUBY" , R.drawable.ruby,"If you want to start with a language that is known for being relatively simple to learn, consider Ruby. Developed in the 1990s, it was designed to have a more human-friendly syntax while still being flexible from the standpoint of its object-oriented architecture that supports procedural and functional programming notation. A web-application framework that is implemented in Ruby is Ruby on Rails (“RoR”). Ruby developers tout it for being an easy language to write in and also for the relatively short learning time required. These attributes have led to a large community of Ruby developers and a growing interest in the language among beginning developers. The average salary for a Ruby developer is around \$121,000 per year."))
        languageList.add(LanguageItem("SCALA" , R.drawable.scala,"TypeScript is a newcomer to top programming language lists, but it’s making headway. It was developed in 2012 by Microsoft and is a typed version of JavaScript that is well suited for large code bases. TypeScript is used to create JavaScript-based projects with typing in both client-side and server-side development, making useful for catching errors and preventing systemic issues."))
        languageList.add(LanguageItem("SQL" , R.drawable.sql,"SQL is a standard database query language. It is used to access and manipulate data in databases. SQL is a declarative language that specifies the desired results, but not the steps to achieve those results. SQL is a powerful tool for accessing and manipulating data, and it is the world's most widely used database query language."))
        languageList.add(LanguageItem("SWIFT" , R.drawable.swift,"A few years ago, Swift made the top 10 in the monthly TIOBE Index ranking of popular programming languages. Apple developed Swift in 2014 for Linux and Mac applications. "))
        languageList.add(LanguageItem("TYPESCRIPT" , R.drawable.typescript,"TypeScript is a newcomer to top programming language lists, but it’s making headway. It was developed in 2012 by Microsoft and is a typed version of JavaScript that is well suited for large code bases. TypeScript is used to create JavaScript-based projects with typing in both client-side and server-side development, making useful for catching errors and preventing systemic issues."))
    }
}