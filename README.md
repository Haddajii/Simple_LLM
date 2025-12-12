
<body>
    <header>
        <h1>Simple LLM Java Client</h1>
        <p>A small Java project that allows students to use a local LLM client (DeepSeek) in their own projects without API keys.</p>
        <p>It handles browser automation behind the scenes using Playwright so you can send messages to the LLM easily.</p>
    </header>
    <section>
        <h2>Requirements</h2>
        <ul>
            <li>Java 17 or higher</li>
            <li>Maven</li>
            <li><strong>Brave browser</strong> installed (Playwright uses it to run DeepSeek locally)</li>
        </ul>
   </section>

  <section>
        <h2>Installation Guide</h2>
        <p>Follow these steps to set up the project locally:</p>

Clone the repo
  

<pre><code>  git clone https://github.com/Haddajii/Simple_LLM.git  </code></pre>


 Enter the project directory
<pre><code>cd Simple_LLM </code></pre>

 Install locally using Maven
<pre><code>  mvn clean install </code></pre>



 
  <section>
    <h2>Usage in Your Project</h2>
    <p>After installing locally, you can use the <code>haddaji_simple_llm</code> function in your Java project.</p>
    <h3>1. Add as a Maven dependency</h3>
    <p>If you installed the project locally, add this to your <code>pom.xml</code>:</p>
    <pre><code>&lt;dependency&gt;
    &lt;groupId&gt;com.haddaji&lt;/groupId&gt;
    &lt;artifactId&gt;Haddaji_Simple_LLM&lt;/artifactId&gt;
    &lt;version&gt;1.0-SNAPSHOT&lt;/version&gt;
&lt;/dependency&gt;</code></pre>
    <h3>2. Example usage</h3>
    <pre><code>import com.haddaji.HaddajiLLM;

public class Main {
    public static void main(String[] args) throws Exception {
        // Send a message to the LLM
        String response = HaddajiLLM.haddaji_simple_llm("Who is the best player in the world?");
        System.out.println(response);
        // Close the client/browser when done
        HaddajiLLM.close();
    }
}
</code></pre>
    <h3>Notes</h3>
    <ul>
        <li>This project uses Playwright for browser automation. Brave browser must be installed and accessible in your PATH.</li>
        <li>No API key is needed; it works by automating the DeepSeek web interface locally.</li>
        <li>It’s intended for learning, experimenting, and student projects.</li>
    </ul>
    <h3>License</h3>
    <p>This project is released under the MIT License. See the <code>LICENSE</code> file for details.</p>
</section>

    
</body>
