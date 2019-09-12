pragma solidity >= 0.4.27 <0.7.0;

contract Logistics{
    address owner;
    struct product{
        uint256 barCode;
        string name;
        string origin;
        string quality;
        uint count;
        uint256 temp;
        uint256 humid;
        uint256 latitude;
        uint256 longitude;
    }
    mapping (uint => product) public productMapping;
    function inputInfo(uint256 BarCode, string memory Name, string memory Origin, string memory Quality) public returns (uint)
    {
         productMapping[BarCode].barCode = BarCode;
         productMapping[BarCode].name = Name;
         productMapping[BarCode].origin = Origin;
         productMapping[BarCode].quality = Quality;
         return BarCode;
    }
    function update(uint256 BarCode, uint256 Temp, uint256 Humid, uint256 Latitude, uint256 Longtitude) public returns(string memory){
        productMapping[BarCode].temp = Temp;
        productMapping[BarCode].humid = Humid;
        productMapping[BarCode].latitude = Latitude;
        productMapping[BarCode].longitude = Longtitude;
        return "Product is updated";
    }
    function returnStatus(uint256 BarCode) public view returns (string memory,
                                                 string memory, 
                                                 string memory, 
                                                 uint256,
                                                 uint256,
                                                 uint256,
                                                 uint256)
    {
        return (productMapping[BarCode].name,
                productMapping[BarCode].origin,
                productMapping[BarCode].quality,
                productMapping[BarCode].temp,
                productMapping[BarCode].humid,
                productMapping[BarCode].latitude,
                productMapping[BarCode].longitude
        );
    }
}