
Stack Workflow
----

Personal project template based on Respo, Boot, ClojureScript, Cirru Sepal, shadow-cljs...

Features:

* Program with Stack Editor
* Hot code swapping
* Basic UI styles
* Fonts and icons packed in Webpack
* Compilation and minification

### Install dependencies

```bash
npm i -g stack-editor
npm i -g shadow-cljs
yarn
```

### Develop

Watch compiling ClojureScript to `node_modules/shadow-cljs/`:

```bash
shadow-cljs --dev
```

Generate development HTML and CSS:

```bash
env=dev node bin/render.js
webpack
```

Run compilers to compile ClojureScript -> JavaScript -> js bundles:

```bash
shadow-cljs --dev
# open another tab in terminal
yarn run dev
```

Start my infancy editor:

```bash
stack-editor
```

### Build apps

Compile and optimize ClojureScript, generate HTML with revision:

```bash
shadow-cljs --once
env=dev node bin/render.js
webpack
```

### Workflow

Workflow https://github.com/mvc-works/stack-workflow

Package jar file and install locally:

```bash
boot build
```

Package jar file and send to Clojars:

```bash
boot deploy
```

Get ClojureScript code:

```bash
op=compile stack-editor
```

### License

MIT
