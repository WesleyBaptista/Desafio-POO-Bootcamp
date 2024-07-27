import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Curso> cursosInscritos = new LinkedHashSet<>();
    private Set<Curso> cursosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.cursosInscritos.addAll(bootcamp.getCursos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Curso> curso = this.cursosInscritos.stream().findFirst();
        if (curso.isPresent()) {
            this.cursosConcluidos.add(curso.get());
            this.cursosInscritos.remove(curso.get());
        } else {
            System.err.println("Você não está matriculado em nenhum curso!");
        }
    }

    public double calcularTotalXp() {
        return this.cursosConcluidos.stream().mapToDouble(curso -> curso.getCargaHoraria() * 10d).sum();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(Set<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public Set<Curso> getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(Set<Curso> cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }
}
