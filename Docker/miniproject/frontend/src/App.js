// frontend/src/App.js
import React from "react";

function App() {
  const styles = {
    appContainer: {
      fontFamily: "Arial, sans-serif",
      color: "#333",
      margin: 0,
      padding: 0,
    },
    navbar: {
      backgroundColor: "#0db7ed",
      padding: "1rem",
      color: "white",
      display: "flex",
      justifyContent: "space-between",
      alignItems: "center",
    },
    navLinks: {
      display: "flex",
      gap: "1rem",
    },
    link: {
      color: "white",
      textDecoration: "none",
    },
    mainContent: {
      padding: "2rem",
    },
    section: {
      marginBottom: "2rem",
    },
    footer: {
      textAlign: "center",
      padding: "1rem",
      backgroundColor: "#f3f3f3",
      marginTop: "2rem",
    },
  };

  return (
    <div style={styles.appContainer}>
      <header style={styles.navbar}>
        <h2>Docker Class</h2>
        <nav style={styles.navLinks}>
          <a href="#about" style={styles.link}>About</a>
          <a href="#resources" style={styles.link}>Resources</a>
          <a href="#contact" style={styles.link}>Contact</a>
        </nav>
      </header>

      <main style={styles.mainContent}>
        <section id="about" style={styles.section}>
          <h3>Welcome to the Docker Class</h3>
          <p>
            Learn how to containerize your applications with Docker. This class
            covers everything from basic concepts to real-world deployment.
          </p>
        </section>

        <section id="resources" style={styles.section}>
          <h3>Class Resources</h3>
          <ul>
            <li>📘 Introduction to Docker</li>
            <li>🛠️ Hands-on Labs</li>
            <li>📦 Dockerfile Examples</li>
          </ul>
        </section>

        <section id="contact" style={styles.section}>
          <h3>Contact Instructor</h3>
          <p>Email: instructor@example.com</p>
        </section>
      </main>

      <footer style={styles.footer}>
        <p>© 2025 Docker Class. All rights reserved.</p>
      </footer>
    </div>
  );
}

export default App;
