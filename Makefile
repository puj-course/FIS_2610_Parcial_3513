# Variables
JAR_FILE = target/your-app.jar
MAIN_CLASS = com.example.Main

# Default target
.PHONY: all
all: build

# Build the project
.PHONY: build
build:
    mvn clean install

# Run the application
.PHONY: run
run: build
    java -jar $(JAR_FILE)

# Clean the project
.PHONY: clean
clean:
    mvn clean

# Run tests
.PHONY: test
test:
    mvn test