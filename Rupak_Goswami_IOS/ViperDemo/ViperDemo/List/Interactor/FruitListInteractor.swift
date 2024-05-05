

import UIKit


class FruitListInteractor: FruitListInputInteractorProtocol {
    
    weak var presenter: FruitListOutputInteractorProtocol?
    
    
    //Web Service Respones
    var WebServiceArray = NSArray()
    var tempjsonObject = NSDictionary()
    var dataDictArray = [[String:String]]()
    
    func getFruitList() {
        self.WebServiceCall()
        presenter?.fruitListDidFetch(fruitList: getAllFruitDetail())
    }
    
    func getAllFruitDetail() -> [Fruit] {
        var fruitList = [Fruit]()
        Thread.sleep(forTimeInterval: 4)
        let allFruitDetail =  self.dataDictArray
        for item in allFruitDetail {
            fruitList.append(Fruit(attributes: item))
        }
        return fruitList
    }
    
    
func WebServiceCall() {
    
    print("WebServiceCall ---> ")
    
    /*
     
     Please Note : If you change the URL to dummy one example
     
     URL : http://universities.hipolabs.com/search?country=United%20Arab%20Emirates
     
     Dummy URL : http://universities.hipolabs.com/search?country=United%20Arab%20EmiratesAAA
     
     Then you will get the error in list page
     
     Also
     
     If there is any issue in Back End Layer User will get notified in list page 
     
     Some issue in Response.Pleasr try after some time
     
     LN -42 In List Page
     */
    
    
var request = URLRequest(url: URL(string:"http://universities.hipolabs.com/search?country=United%20Arab%20Emirates")!)
             request.httpMethod = "GET"
             URLSession.shared.dataTask(with:request, completionHandler: {(data, response, error) in
             guard let data = data, error == nil else { return }
             do {
             let json = try JSONSerialization.jsonObject(with: data, options: .allowFragments)
            // print("Web Service Response ---> " , json)
             self.WebServiceArray = (json as AnyObject) as! NSArray
            // print("WebServiceArray --->",self.WebServiceArray,self.WebServiceArray.count)
             if self.WebServiceArray.count > 0 {
            
             for i in 0  ..< self.WebServiceArray.count{
             self.tempjsonObject = self.WebServiceArray[i] as! NSDictionary
                // print("----> ", self.tempjsonObject["name"]! , self.tempjsonObject["country"]!)
                 var dataDict = [String : String]()
                 dataDict["name"] = self.tempjsonObject["name"]! as? String
                 dataDict["country"] = self.tempjsonObject["country"]! as? String
                 dataDict["stateprovince"] = self.tempjsonObject["state-province"]! as? String
                 dataDict["alphatwocode"] = self.tempjsonObject["alpha_two_code"]! as? String
                 self.dataDictArray.append(dataDict)
             }
       //  print("dataDictArray ---> ", self.dataDictArray)
                 /*
                  We are storing the service response in UserDefaults
                  */
         UserDefaults.standard.set(self.dataDictArray, forKey:"ListData")
         }
         else{
         print("No Data In API Respones")
         }
             }
            catch let error as NSError {
             print(error)
             }
             }).resume()
         }
}
