using System.Collections;
using System.Threading;
using UnityEngine;
using UnityEngine.Networking;
using UnityEngine.UI;

public class Control : MonoBehaviour
{
    int tenths;
    int seconds;
    int minutes;
    float counter;
    bool timerEnabled;

    // Cached references
    public Text tenthsText;
    public Text secondsText;
    public Text minutesText;
    public Button playPauseButton;
    public Button resetButton;
    public Image image;

    // Download reference
    UnityWebRequest httpClient;

    // Slider reference
    public Slider downloadingBar;

    // Start is called before the first frame update
    void Start()
    {
        Reset();
    }

    // Update is called once per frame
    void Update()
    {
        if (timerEnabled)
        {
            //Debug.Log(counter);
            counter += Time.deltaTime;
            //TODO: Implement timer logic
            if (counter > 0.1f)
            {
                counter = 0f;
                tenths++;
                tenthsText.text = tenths.ToString();
                if (tenths >= 9)
                {
                    tenths = 0;
                    seconds++;
                    secondsText.text = seconds.ToString("00");
                    if (seconds > 59)
                    {
                        seconds = 0;
                        minutes++;
                        minutesText.text = minutes.ToString("00");
                    }
                }
            }
        }
        // Move Slider
        downloadingBar.GetComponent<Slider>().value = httpClient.downloadProgress;
    }

    public void PlayPause()
    {
        timerEnabled = !timerEnabled;
        if (timerEnabled)
        {
            playPauseButton.gameObject.GetComponentInChildren<Text>().text = "Pause";
        }
        else
        {
            playPauseButton.gameObject.GetComponentInChildren<Text>().text = "Play";
        }
    }

    public void Reset()
    {
        tenths = 0;
        seconds = 0;
        minutes = 0;
        counter = 0f;
        timerEnabled = false;
        tenthsText.text = tenths.ToString("0");
        secondsText.text = seconds.ToString("00");
        minutesText.text = minutes.ToString("00");
    }

    public void LoadImageCoroutine()
    {
        StartCoroutine(LoadImageBlocking());
    }

    public IEnumerator LoadImageBlocking()
    {
        using (UnityWebRequest httpClient = new UnityWebRequest("https://spdvistorage.blob.core.windows.net/clickycrates-blobs/default/4-2-pokemon-transparent.png"))
        {
            Debug.Log("Getting image...");
            httpClient.downloadHandler = new DownloadHandlerBuffer();
            yield return httpClient.SendWebRequest(); // Blocking call
            while (httpClient.downloadProgress < 1.0f)
            {
                //Thread.Sleep(10);
                Debug.Log(httpClient.downloadProgress * 100 + "% (Bytes downloaded: " + httpClient.downloadedBytes / 1024 + " KB");
            }
            Debug.Log("hpptClient.isDone = " + httpClient.isDone);
            if (httpClient.isNetworkError || httpClient.isHttpError)
            {
                Debug.Log(httpClient.error);
            }
            else
            {
                byte[] textureBinary = httpClient.downloadHandler.data;
                Texture2D texture = new Texture2D(1, 1);
                texture.LoadImage(textureBinary);
                image.sprite = Sprite.Create(texture, new Rect(0.0f, 0.0f, texture.width, texture.height), new Vector2(0.5f, 0.5f), 100.0f);
            }
        }
    }

}
