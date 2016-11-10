
Stack Workflow
----

Personal project template based on Respo, Boot, ClojureScript, Cirru Sepal, [Lumo][lumo]...

[lumo]: https://github.com/anmonteiro/lumo/tree/master/src/cljs/lumo

### Develop

Genetate HTML(`target/index.html`), watch and build ClojureScript:

```bash
boot dev!
```

Compile and optimize ClojureScript, generate HTML with revision:

```bash
boot build-advanced
export boot_deps=`boot show -c`
lumo -c $boot_deps:src/ -i render.cljs
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
