
Stack Workflow
----

Personal project template based on Respo, Boot, ClojureScript, Cirru Sepal, shadow-cljs...

### Usage

Compilation steps:

```text
ir.edn  -> src/           -> compiled/    -> dist/
Cirru   -> ClojureScript  -> JavaScript   -> App
```

Dependencies:

```bash
# Node.js , JVM
npm i -g stack-editor
npm i -g shadow-cljs
yarn
```

To run in development:

```bash
stack-editor
# another tty
yarn cljs
# another tty
yarn dev
```

To build:

```bash
yarn build
```

Assets would be like: http://repo.tiye.me/mvc-works/stack-workflow/

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
