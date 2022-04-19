let board;

// 블로그 상단바에 게시판 클릭시 
$("#main").click(() => {
    $("#boardPage").load(location.href + " #mainboard");
});
$("#adopt").click(() => {
    $("#boardPage").load(location.href + " #adoptboard");
    board = "adopt";
    boardList(board);
});
$("#region").click(() => {
    $("#boardPage").load(location.href + " #regionboard");
    board = "region";
    boardList(board);
});
$("#free").click(() => {
    $("#boardPage").load(location.href + " #freeboard");
    board = "free";
    boardList(board);
});

async function boardList(board) {

    console.log(board);

    let response = await fetch(`/post/${board}`);
    let responseParse = await response.json();

    console.log(responseParse);

    if (responseParse.code == 1 && board == "adopt") {
    }
}