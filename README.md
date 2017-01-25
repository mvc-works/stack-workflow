
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

### Develop

Genetate HTML(`target/index.html`), watch and build ClojureScript:

```bash
webpack
boot editor!
# open another tab in terminal
boot dev
```

Compile and optimize ClojureScript, generate HTML with revision:

```bash
boot build-advanced
webpack
export boot_deps=`boot show -c`
lumo -Kc $boot_deps:src/ -i tasks/render.cljs
```

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
boot generate-code
```

### Develop

Workflow https://github.com/mvc-works/stack-workflow

### License

MIT
