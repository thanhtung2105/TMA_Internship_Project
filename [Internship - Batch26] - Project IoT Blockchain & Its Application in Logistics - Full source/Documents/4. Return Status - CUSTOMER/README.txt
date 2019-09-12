Phần giao diện (WebUI) mẫu đã được updated tại trang web-test:
tma-batch26-testnet.rf.gd
với barcode để tra cứu test là: 0107201913092019
sử dụng google map API để tạo map nhưng do bản free nên chỉ xem và dùng
được dưới hình thức Dev.

Giao diện WebUI chủ yếu sẽ được viết bằng NodeJS Application sau 
đó được up lên Server máy ảo Heroku. Việc viết WebUI sẽ liên kết trực 
tiếp tới Rinkeby TestNet để lấy dữ liệu của các giao dịch thông qua 
các hàm của thư viện Web3js.