<b> <h2> "Mate-Info" App - Project for professional certification in Informatics </h2> </b>

I made this app at the age of 18, while I was in 12th grade of high school. The project itself was designed for my professional certification in Informatics.

The app came as a need while I was preparing for the admission exam at the Faculty of Informatics at BBU Cluj-Napoca, and that is solving admission problems anywhere and anytime. The app has 2 main functionalities: exam simulation (24 problems in 3 hours) and training problems (showing problems for as long as the user wants). The problems added to this app were extracted from the faculty's examples.

Example of problem showing while in exam mode:

![Example of problem while in exam mode](https://files.cotoirares.com/img/Screenshot%202024-07-17%20at%2014.33.40.png)

Example of problem showing while in practice mode:

![Example of problem showing while in practice mode](https://files.cotoirares.com/img/Screenshot%202024-07-17%20at%2014.35.32.png)

The app was programmed using:
<ul> 
  <li>XML (for the visual design of the app);</li>
  <li>Java (for the functionalities);</li> 
  <li> Google Firebase (as Database). </li>
</ul>

The Database was used in order to store:
<ul> 
  <li>The users - using Firebase Auth;</li>
  <li>The problems as objects, having as attributes: 
    <ul>
      <li>The problem statement</li>
      <li>The answer choices: A, B, C or D</li>
      <li>The correct answer of the problem (which was compared to the user's answer when grading the problem answer)</li>
    </ul>
  </li> 
</ul>

The full documentation of the app (including code breakdown) may be checked here: https://bit.ly/atestat-doc (Romanian only).

<b> IMPORTANT NOTE </b>: this is not a functional application for public use. It is just a code sample of my professional certification in Informatics, hence the app is linked to a non-existing Database (with a non-existing API key), in order to demonstrate the codebase of this app. 
