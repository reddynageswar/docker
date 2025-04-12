stage('Create Table in Docker MySQL') {
    steps {
        script {
            // DB connection details for Docker container
            def dbUrl = 'jdbc:mysql://localhost:3306/miniproject_db_1'
            def dbUser = 'root'
            def dbPassword = 'rootpassword'
            def dbDriver = 'com.mysql.cj.jdbc.Driver'

            // Load JDBC and connect
            @Grab('mysql:mysql-connector-java:8.0.33')
            import groovy.sql.Sql

            def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)

            def createTableQuery = """
                CREATE TABLE IF NOT EXISTS users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    stage_name VARCHAR(255),
                    status VARCHAR(50),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
            """

            echo "🛠 Creating table inside Docker MySQL..."
            sql.execute(createTableQuery)
            echo "✅ Table 'pipeline_status' created successfully."

            sql.close()
        }
    }
}
