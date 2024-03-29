package br.unisinos.parthenos.generator.prolog.fact;

import br.unisinos.parthenos.generator.annotation.Arity;
import br.unisinos.parthenos.generator.annotation.Functor;
import br.unisinos.parthenos.generator.prolog.term.Atom;
import br.unisinos.parthenos.generator.prolog.term.Term;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.file.Path;

@Functor("use")
@Arity(1)
@Getter
@AllArgsConstructor
public class Use extends Fact {
  private Path path;

  private String getEscapedPath() {
    return this.getPath().toAbsolutePath().toString().replace("\\", "/");
  }

  private Atom getPathAtom() {
    return new Atom(this.getEscapedPath());
  }

  @Override
  public Term<?>[] getArguments() {
    return new Term<?>[]{this.getPathAtom()};
  }
}
