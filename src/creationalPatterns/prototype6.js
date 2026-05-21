class PostPrototype {
  constructor({ candidato, category, edad, username, ciudad, imageDataUrl }) {
    this.candidato = candidato;
    this.category = category;
    this.edad = edad;
    this.username = username;
    this.ciudad = ciudad;
    this.imageDataUrl = imageDataUrl || '';
  }
  clone() {
    return new PostPrototype({
      Candidato: this.candidato,
      category: this.category,
      edad: this.edad,
      username: this.username,
      ciudad: this.ciudad,
      imageDataUrl: this.imageDataUrl
    });
  }
  withNewId() {
    const copy = this.clone();
    copy.id = String(Date.now());
    copy.createdAt = new Date().toISOString();
    return copy;
  }
}

module.exports = { PostPrototype };
