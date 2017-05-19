
Stack Workflow
----

Personal project template based on Respo, Boot, ClojureScript, Cirru Sepal, [Lumo][lumo]...

[lumo]: https://github.com/anmonteiro/lumo/tree/master/src/cljs/lumo

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
boot # for fetch deps on Clojars
```

Generate `$deps` that lumo needs:

```bash
export deps=`boot show -c`
```

### Develop

Generate development HTML and CSS:

```bash
env=dev lumo -Kc $deps:src/ -i tasks/render.cljs
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
boot build-advanced
lumo -Kc $deps:src/ -i tasks/render.cljs
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
