let vote = {
  coffee: 0,
  tea: 0,
};

async function castVote(option) {
  await fetch(`https://demo.samintejas.in/api/vote?option=${option}`, {
    method: "GET",
  });
}

async function leader() {
  const response = await fetch("https://demo.samintejas.in/api/msg");
  const data = await response.json();
  return data.message;
}

async function updateLeader() {
  const message = await leader();
  document.getElementById("result").innerText = `${message}`;
}

document.addEventListener("DOMContentLoaded", () => {
  document.getElementById("coffeebtn").addEventListener("click", async () => {
    await castVote("coffee");
    await updateLeader();
  });

  document.getElementById("teabtn").addEventListener("click", async () => {
    await castVote("tea");
    await updateLeader();
  });
});
