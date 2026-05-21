class BasePost {
  constructor(data) {
    this.id = data.id;
    this.candidato = data.candidato;
    this.edad = data.edad;
    this.category = data.category;
    this.ciudad = data.ciudad;
    this.username = data.username;
    this.imageDataUrl = data.imageDataUrl;
    this.createdAt = data.createdAt;
  }
  getData() {
    return { ...this };
  }
}

class PostDecorator {
  constructor(candidato) {
    this.candidato = candidato;
  }
  getData() {
    return this.post.getData();
  }
}

class TimestampDecorator extends PostDecorator {
  getData() {
    const data = this.candidato.getData();
    data.createdAt = new Date().toISOString();
    data.updatedAt = new Date().toISOString();
    return data;
  }
}

class PartidoDecorator extends PostDecorator {
  constructor(candidato, partidoEmail) {
    super(candidato);
    this.partidoEmail = partidoEmail;
  }
  getData() {
    const data = this.candidato.getData();
    data.partido = this.partidoEmail;
    return data;
  }
}

module.exports = { BasePost, PostDecorator, TimestampDecorator, PartidoDecorator };
