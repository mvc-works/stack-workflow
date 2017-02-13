
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

First load dependencies:

```bash
npm i
webpack
export boot_deps=`boot show -c`
```

Since Boot boots slowly, I cached the result a file, which contains paths of my laptop:

```bash
source tasks/class-path.sh
```

Genetate HTML(`target/index.html`), watch and build ClojureScript:

```bash
env=dev lumo -Kc $boot_deps:src/ -i tasks/render.cljs
lumo -Kc $boot_deps:src/ -i tasks/server.cljs
# open another tab in terminal
boot dev
```

Compile and optimize ClojureScript, generate HTML with revision:

```bash
boot build-advanced
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
op=compile lumo -Kc $boot_deps:src/ -i tasks/server.cljs
```

### Develop

Workflow https://github.com/mvc-works/stack-workflow

### License

MIT
