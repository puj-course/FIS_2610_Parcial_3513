# Parcial — Fundamentos de Ingeniería de Software  
## Sistema de Información Electoral (Elecciones 2026)

# Objetivos y Guía de Actividades

## 1. Identificación de las Historias de Usuario

### 1.1 Descripción

Utilizando el **diagrama UML de requerimientos proporcionado**, los estudiantes deben identificar todas las historias de usuario.

Este proceso debe realizarse utilizando la plantilla vista en clase:

```
Como [tipo de usuario]  
Quiero [funcionalidad o acción]  
Para [beneficio u objetivo]
```

### 1.2 Asignación

- Cada miembro del equipo debe recibir **al menos una historia de usuario**.
- Todas las historias de usuario deben estar **asignadas a un miembro del grupo**.

### 1.3 Creación de Issues

Para cada historia de usuario identificada se debe crear un **issue** en el repositorio de GitHub del proyecto:

```
Project-Parcial1
```

En el título de cada issue se debe agregar el prefijo del grupo.

**Ejemplo**

```
G1- Implementación de login
```

---

# 2. Creación y Gestión de Issues en GitHub

Cada issue debe incluir la siguiente información:

### 2.1 Etiqueta

Tipo de tarea:

- Implementación
- Diseño
- Documentación

### 2.2 Tamaño

Según la complejidad de la tarea:

- **S** — Pequeña  
- **M** — Mediana  
- **L** — Grande  

### 2.3 Prioridad

Definir la urgencia dentro de la planificación del sprint.

### 2.4 Estimación

Se deben asignar **puntos de historia utilizando la técnica PokerScrum**.

### 2.5 Sprint

Asignar cada tarea a uno de los **2–4 sprints del proyecto**.

### 2.6 Milestone (Épica)

Cada issue debe estar asociado a una **milestone**, que representa una **épica o entrega de valor importante del sistema**.

---

# 3. Uso Correcto de Git

## 3.1 Ramas en GitHub

Cada grupo debe:

1. Clonar el repositorio.
2. Revisar la rama `develop`.
3. Dentro de la carpeta:

```
SCR/
```

cada grupo encontrará una **subcarpeta específica para su código**.

---

## 3.2 Creación de Rama Remota

Los grupos deben crear una rama remota en GitHub con el nombre del grupo.

**Ejemplo**

```
Grupo1
```

---

## 3.3 Desarrollo en la Rama del Grupo

Todos los miembros del equipo deben desarrollar sus funcionalidades **directamente en la rama del grupo**.

---

## 3.4 Merge a la Rama develop

Una vez que la estructura de **clases y métodos del sistema esté completa**, se debe realizar un **merge de la rama del grupo hacia la rama `develop`**.

El **monitor del curso** será asignado como **revisor del merge**.

---

## 3.5 Commits

Cada miembro del equipo debe realizar **commits frecuentes y descriptivos**.

Los commits deben:

- Estar relacionados con los **issues del proyecto**
- Seguir la convención **Conventional Commits**

### Ejemplos

```
feat: implementación de la clase User para el login
```

```
docs: actualización del diagrama de clases del sistema
```

---

# 4. Gestión de Conflictos

## 4.1 Prevención de Conflictos

Los equipos deben seguir las instrucciones del flujo de trabajo para **evitar conflictos de código**.

---

## 4.2 Resolución de Conflictos

Si surgen conflictos durante el proceso de **merge**, se deben resolver de manera adecuada **sin afectar el trabajo de otros equipos**.

---

# Estructura del Proyecto

La estructura del repositorio **Project-Parcial1** está organizada para separar la configuración, el código fuente, los scripts de apoyo y los archivos de documentación del proyecto.

```
Project-Parcial1
│
├── conf/                    # Archivos de configuración del proyecto
│
├── docs/                    # Documentos del proyecto (Diagrama UML)
│
├── scripts/                 # Scripts auxiliares para ejecución o automatización
│
├── src/                     # Código fuente del sistema
│   └── grupo1               # Carpeta Equipo 1
│   └── ......
│   └── grupo5               # Carpeta Equipo 5
│   └── EjemploBase.java     #Ejemplo de estructura inicial del proyecto
│
├── .gitignore               # Archivos y carpetas ignoradas por Git
│
├── CHANGELOG.md             # Registro de cambios del proyecto
│
├── CONTRIBUTING.md          # Guía para contribuir al proyecto
│
├── Dockerfile               # Configuración para crear la imagen Docker
│
├── docker-compose.yml       # Configuración de servicios con Docker Compose
│
├── LICENSE                  # Licencia del proyecto
│
├── Makefile                 # Comandos de automatización del proyecto
│
├── pom.xml                  # Configuración del proyecto Maven
│
└── README.md                # Documentación principal del proyecto
```
## Organización del Código

Cada grupo debe trabajar **exclusivamente dentro de su carpeta** correspondiente:

- `grupo1`
- `...`
- `grupo5`

Dentro de estas carpetas se deben implementar:

- clases del sistema
- métodos requeridos
- lógica del modelo de clases

La clase `Main.java` será utilizada como **punto de entrada del sistema** para realizar pruebas de ejecución.

## Pruebas

El directorio `src/test` contiene archivos para realizar **pruebas del sistema** y validar el funcionamiento del código desarrollado.

---

# Flujo de Trabajo del Proyecto

1. Identificar historias de usuario  
2. Crear issues en GitHub  
3. Planificar sprints  
4. Crear rama del grupo  
5. Implementar clases y métodos  
6. Realizar commits con conventional commits  
7. Realizar merge hacia `develop`

---

# Tecnologías Utilizadas

- Git
- GitFlow
- UML
- Metodologías Ágiles (Scrum)
- POO
