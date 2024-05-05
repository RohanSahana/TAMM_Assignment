

import UIKit

class FruitListView: UIViewController,FruitListViewProtocol {
    
    @IBOutlet var fruitTblView: UITableView!
    
    var presenter:FruitListPresenterProtocol?
    var fruitList = [Fruit]()
    
    var db:DBHelper = DBHelper()
    var persons:[Person] = []

    
    override func viewDidLoad() {
        super.viewDidLoad()
//        FruitListWireframe.createFruitListModule(fruitListRef: self)
//        presenter?.viewDidLoad()
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        print("viewWillAppear persons" , persons.count)
        
        /*
        We have not used refresh CTA in details page as we are calling Service Again To Load the data from Response and refresh the List Page
         */
        
        FruitListWireframe.createFruitListModule(fruitListRef: self)
        presenter?.viewDidLoad()

    }

    func showFruits(with fruits: [Fruit]) {
        fruitList = fruits
        print("fruitList ---> "  , fruitList.count)
       
        if(fruitList.count > 0){
            /* Option 1
             Getting Data from UserDefaults
             
             Plrease Note : As the data will be saved from Service we can directly load the data from UserDefaults not required the service call everytime
             */
            // print("---> ", UserDefaults.standard.array(forKey: "ListData") ?? [])
            
            /* Option 2
            Here We Can Also Store the data using sqllite
             */
            if(persons.count == 0){
                for i in 0  ..< self.fruitList.count{
                    db.insert(name:fruitList[i].name , country: fruitList[i].country)
                }
                persons = db.read()
                print("persons Count after Save" , persons.count)
            }
            
            /*
             Please Note : We are calling the table view from Local DB after we hit the service & From Details View we are calling the service again.We Can also delete the local DB and call the list from service
             */
        
            fruitTblView.reloadData()
        } else{
            let alert = UIAlertController(title: "TAMM APP", message: "Some issue in Response.Pleasr try after some time", preferredStyle: UIAlertController.Style.actionSheet)
            alert.addAction(UIAlertAction(title: "OK", style: UIAlertAction.Style.destructive, handler: nil))
            self.present(alert, animated: true, completion: nil)
        }
    }
}

extension FruitListView: UITableViewDataSource, UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = fruitTblView.dequeueReusableCell(withIdentifier: "fruitCell" , for: indexPath) as! TableViewCell
        let fruit = persons[indexPath.row]
        cell.NameLbl?.text = fruit.name
        cell.UnvLbl?.text = fruit.country
        return cell
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return fruitList.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        presenter?.showFruitSelection(with: fruitList[indexPath.row], from: self)
    }
    
}

